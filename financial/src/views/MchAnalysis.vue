<template>
  <main class="main-content">
    <h1>商家数据分析</h1>

    <div class="analysis-switch">
      <router-link to="/MchAnalysis_" class="switch-button">具体分析</router-link>
    </div>

    <!-- 切换按钮 -->
    <div class="analysis-switch">
      <button @click="setAnalysisMode('offline')" :class="{ active: analysisMode === 'offline' }">离线统计</button>
      <button @click="setAnalysisMode('realtime')" :class="{ active: analysisMode === 'realtime' }">实时统计</button>
    </div>

    <!-- 整体统计分析 -->
    <section class="overall-analysis">
      <h2 v-if="analysisMode === 'offline'">整体统计分析（离线）</h2>
      <h2 v-if="analysisMode === 'realtime'">整体统计分析（实时）</h2>

      <div class="info-cards">
        <div class="info-card cyan">
          <h2>商家总数量</h2>
          <p>{{ analysisMode === 'offline' ? totalMchs : todayMchs }}</p>
        </div>
        <div class="info-card yellow">
          <h2>商家总营业额</h2>
          <p>$ {{ analysisMode === 'offline' ? totalAmount : todayAmount }}</p>
        </div>
        <div class="info-card cyan">
          <h2>总交易数</h2>
          <p>{{ analysisMode === 'offline' ? totalTrades : todayTrades }}</p>
        </div>
      </div>

      <!-- 图表 -->
      <div class="category-analysis">
        <h3>根据统计方式分类统计</h3>
        <div>
          <label for="statistics-type">选择统计方式：</label>
          <select id="statistics-type" @change="updateChart">
            <option value="revenue">营业额</option>
            <option value="profit">利润</option>
            <option value="quantity">销售数量</option>
          </select>
        </div>
        <div class="chart-placeholder">
          <canvas ref="barChart"></canvas>
        </div>
      </div>
    </section>
  </main>
</template>

<script>
import Chart from "chart.js/auto";
import api from "../api/api.js";

export default {
  name: "MchAnalysis",
  data() {
    return {
      analysisMode: "offline", // 当前分析模式：offline 或 realtime
      totalAmount: 0,
      totalMchs: 0,
      totalTrades: 0,
      todayAmount: 0,
      todayMchs: 0,
      todayTrades: 0,
      chart: null,
      intervalId: null, // 定时器 ID
      statisticsData: {
        offline: {
          revenue: [100, 200, 300, 500],
          profit: [50, 80, 120],
          quantity: [300, 500, 800],
        },
        realtime: {
          revenue: [120, 230, 340, 560],
          profit: [60, 90, 130],
          quantity: [320, 520, 850],
        },
      },
      labelsData: {
        offline: {
          revenue: ["0-100", "100-200", "200-300", "300+"],
          profit: ["0-50", "50-100", "100+"],
          quantity: ["0-500", "500-1000", "1000+"],
        },
        realtime: {
          revenue: ["0-150", "150-250", "250-350", "350+"],
          profit: ["0-60", "60-120", "120+"],
          quantity: ["0-600", "600-1100", "1100+"],
        },
      },
    };
  },
  methods: {
    setAnalysisMode(mode) {
      this.analysisMode = mode;
      this.updateChart({ target: { value: "revenue" } });
    },
    async fetchOfflineData() {
      try {
        const response = await api.getOfflineMchTotalMessage();
        this.totalAmount = response.data.data[0];
        this.totalMchs = response.data.data[1];
        this.totalTrades = response.data.data[2];
      } catch (error) {
        console.error("获取离线数据失败", error);
      }
    },
    async fetchRealtimeData() {
      try {
        const response = await api.getRealtimeMchTotalMessage();
        this.todayAmount = response.data.data[0];
        this.todayMchs = response.data.data[1];
        this.todayTrades = response.data.data[2];
      } catch (error) {
        console.error("获取实时数据失败", error);
      }
    },
    async fetchOfflineChartData() {
        try{
        const response = await api.getOfflineMchTotalChartData();
        this.statisticsData = response.data.data.statisticsData;
        this.labelsData = response.data.data.labelsData; 
      }catch(error){
        console.error('获取离线图表信息失败', error);
      }
    },
    async fetchRealtimeChartData() {
        try{
        const response = await api.getRealtimeMchTotalChartData();
        this.statisticsData = response.data.data.statisticsData;
        this.labelsData = response.data.data.labelsData; 
      }catch(error){
        console.error('获取图表信息失败', error);
      }
    },
    updateChart(event) {
      const selectedType = event.target.value;
      const currentMode = this.analysisMode;

      this.chart.data.labels = this.labelsData[currentMode][selectedType];
      this.chart.data.datasets[0].data = this.statisticsData[currentMode][selectedType];
      this.chart.data.datasets[0].label = selectedType === "revenue" ? "营业额" : selectedType === "profit" ? "利润" : "销售数量";
      this.chart.update();
    },
    async updateRealtime(){
        this.fetchRealtimeData();
        this.fetchRealtimeChartData();
    }
  },
  async created() {
    await this.fetchOfflineData();
    await this.fetchRealtimeData();
    this.intervalId = setInterval(() => {
        this.updateRealtime(); // 这里是引用，而不是调用
    }, 5000);
  },
  mounted() {
    const ctx = this.$refs.barChart.getContext("2d");
    this.chart = new Chart(ctx, {
      type: "bar",
      data: {
        labels: this.labelsData.offline.revenue,
        datasets: [
          {
            label: "营业额",
            data: this.statisticsData.offline.revenue,
            backgroundColor: "rgba(75, 192, 192, 0.2)",
            borderColor: "rgba(75, 192, 192, 1)",
            borderWidth: 1,
          },
        ],
      },
      options: {
        responsive: true,
        plugins: {
          legend: { position: "top" },
          title: { display: true, text: "分类柱状图" },
        },
      },
    });
  },
  beforeDestroy() {
    // 清除定时器
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
  },
  
};
</script>


<style scoped>
.main-content {
  background: #f6faff; /* 白色背景 */
  padding: 20px;
  min-height: 100vh; /* 确保背景至少覆盖整个屏幕 */
  box-sizing: border-box; /* 包括内边距在内计算高度 */
}
.analysis-switch {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.analysis-switch button {
  padding: 10px 20px;
  margin: 0 5px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  background-color: #ecf0f1;
  color: #34495e;
  font-size: 16px;
}

.analysis-switch button.active {
  background-color: #3498db;
  color: white;
}

.info-cards {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}

.info-card {
  flex: 1;
  margin: 10px;
  padding: 20px;
  border-radius: 10px;
  color: white;
  text-align: center;
}

.cyan {
  background-color: #1abc9c;
}

.yellow {
  background-color: #f1c40f;
}

.chart-placeholder {
  height: 300px;
}

.chart-placeholder {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中（如果有额外高度） */
  height: 300px;
  background: #ecf0f1;
  border-radius: 8px;
  color: #95a5a6;
  font-size: 16px;
  margin: 0 auto; /* 让容器在其父级中居中 */
  max-width: 100%; /* 确保图表在小屏幕上不会超出 */
}


</style>
