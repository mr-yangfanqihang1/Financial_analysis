<template>
  <main class="main-content">
    <h1>具体商家分析</h1>

    <!-- 切换按钮 -->
    <div class="analysis-switch">
      <router-link to="/MchAnalysis" class="switch-button">整体分析</router-link>
    </div>

    <!-- 商家输入 -->
    <section class="merchant-selector">
      <label for="merchant-id">输入商家 ID：</label>
      <input
        id="merchant-id"
        v-model="inputMerchantId"
        placeholder="请输入商家 ID"
        @keyup.enter="fetchMerchantData"
      />
      <button @click="fetchMerchantData">查询</button>
    </section>

    <!-- 商家数据展示 -->
    <section v-if="merchantStats && selectedMerchantId" class="merchant-details">
      <h2>商家 ID：{{ selectedMerchantId }}</h2>

      <!-- 商家统计数据卡片展示 -->
      <div class="info-cards">
        <div class="info-card cyan">
          <h2>新增用户数</h2>
          <p>{{ merchantStats.newUsers }}</p>
        </div>
        <div class="info-card yellow">
          <h2>总销售额</h2>
          <p>$ {{ merchantStats.totalRevenue.toFixed(2) }}</p>
        </div>
        <div class="info-card cyan">
          <h2>总销量</h2>
          <p>{{ merchantStats.totalSales }}</p>
        </div>
      </div>

      <!-- 切换按钮 -->
      <div class="toggle-buttons">
        <button @click="toggleChart('sales')" :class="{'active': chartType === 'sales'}">销量</button>
        <button @click="toggleChart('revenue')" :class="{'active': chartType === 'revenue'}">销售额</button>
      </div>

      <!-- 近一周销量与销售额折线图 -->
      <div class="chart-section">
        <h3>近一周日销量/销售额</h3>
        <canvas ref="salesRevenueChart"></canvas>
      </div>
    </section>

    <!-- 无商家时的提示 -->
    <p v-else class="no-merchant">请输入商家 ID 以查看数据</p>
  </main>
</template>

<script>
import Chart from "chart.js/auto";
import api from "../api/api.js";

export default {
  name: "MerchantAnalysis",
  data() {
    return {
      inputMerchantId: "", // 输入的商家 ID
      selectedMerchantId: null, // 当前选择的商家 ID
      merchantStats: null, // 商家统计数据
      salesRevenueChart: null, // 销量与销售额图表实例
      chartType: "sales", // 默认显示销量
    };
  },
  methods: {
    // 获取指定商家的数据
    async fetchMerchantData() {
      const merchantId = this.inputMerchantId.trim();
      if (!merchantId) {
        alert("请输入有效的商家 ID！");
        return;
      }

      console.log("请求商家数据，商家 ID:", merchantId);  // 调试：确认输入的商家 ID

      try {
        const response = await api.getMerchantStats(merchantId); // 获取商家数据

        if (response && response.data && response.data.stats) {
          this.selectedMerchantId = merchantId;
          this.merchantStats = response.data.stats;

          // 更新图表
          this.updateChart(response.data.weeklySales, response.data.weeklyRevenue);
        } else {
          console.error("返回的数据格式错误:", response);
          alert("无法获取商家数据，请检查商家 ID 是否正确！");
        }
      } catch (error) {
        console.error("获取商家数据失败:", error);
        alert("无法获取商家数据，请检查商家 ID 是否正确！");
      }
    },
    // 切换图表显示
    toggleChart(type) {
      this.chartType = type;
      // 强制更新图表显示状态
      if (this.salesRevenueChart) {
        this.salesRevenueChart.data.datasets[0].hidden = type === "revenue";
        this.salesRevenueChart.data.datasets[1].hidden = type === "sales";
        this.salesRevenueChart.update();
      }
    },
    // 更新图表数据
    updateChart(weeklySales, weeklyRevenue) {
      const labels = ["周一", "周二", "周三", "周四", "周五", "周六", "周日"];

      // 如果图表实例不存在，创建新图表
      if (!this.salesRevenueChart) {
        const ctx = this.$refs.salesRevenueChart.getContext("2d");
        this.salesRevenueChart = new Chart(ctx, {
          type: "line",
          data: {
            labels: labels,
            datasets: [
              {
                label: "日销量",
                data: weeklySales,
                backgroundColor: "rgba(75, 192, 192, 0.2)",
                borderColor: "rgba(75, 192, 192, 1)",
                borderWidth: 2,
                tension: 0.3,
                hidden: this.chartType === "revenue",
              },
              {
                label: "日销售额",
                data: weeklyRevenue,
                backgroundColor: "rgba(255, 159, 64, 0.2)",
                borderColor: "rgba(255, 159, 64, 1)",
                borderWidth: 2,
                tension: 0.3,
                hidden: this.chartType === "sales",
              },
            ],
          },
          options: {
            responsive: true,
            plugins: {
              legend: {
                display: true,
              },
            },
          },
        });
      } else {
        // 如果图表实例已经存在，只更新数据
        this.salesRevenueChart.data.datasets[0].data = weeklySales;
        this.salesRevenueChart.data.datasets[1].data = weeklyRevenue;

        // 根据选择的图表类型切换显示
        this.salesRevenueChart.data.datasets[0].hidden = this.chartType === "revenue";
        this.salesRevenueChart.data.datasets[1].hidden = this.chartType === "sales";

        // 强制刷新图表
        this.salesRevenueChart.update();
      }
    },
  },

};
</script>

<style scoped>
.main-content {
  background: #f6faff;
  padding: 20px;
  min-height: 100vh;
}

.analysis-switch {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.merchant-selector {
  margin-bottom: 20px;
  text-align: center;
}

.merchant-selector input {
  padding: 5px;
  margin-right: 10px;
}

.merchant-selector button {
  padding: 5px 10px;
  border: none;
  background-color: #3498db;
  color: white;
  cursor: pointer;
  border-radius: 5px;
}

.merchant-selector button:hover {
  background-color: #2980b9;
}

.chart-section {
  margin-bottom: 40px;
}

.chart-section canvas {
  width: 100%;
  max-width: 600px;
  margin: 0 auto;
  display: block;
}

.no-merchant {
  text-align: center;
  font-size: 18px;
  color: #888;
}

/* 信息卡样式 */
.info-cards {
  display: flex;
  justify-content: space-between;
  margin-bottom: 40px;
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

/* 切换按钮样式 */
.toggle-buttons {
  display: flex;
  justify-content: flex-start;
  margin-bottom: 20px;
}

.toggle-buttons button {
  margin-right: 20px;
  padding: 10px 20px;
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.toggle-buttons button:hover {
  background-color: #2980b9;
}

.toggle-buttons button.active {
  background-color: #2980b9;
}
</style>
