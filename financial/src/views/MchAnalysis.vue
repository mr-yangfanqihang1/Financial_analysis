<template>
    <!-- 主体内容 -->
    <main class="main-content">
      <h1>商家数据分析</h1>

      <!-- 整体统计分析模块 -->
      <section class="overall-analysis">
        <h2>整体统计分析</h2>

        <div class="info-cards">
            <router-link to="/" class="info-card cyan">
                <h2>商家总数量</h2>
                <p>1234</p>
            </router-link>
        
            <router-link to="/" class="info-card yellow">
                <h2>商家总营业额</h2>
                <p>¥ 12,345,678</p>
            </router-link>
            <router-link to="/" class="info-card cyan">
                <h2><div class=""></div></h2>
                <p>...</p>
                <small>其他</small>
            </router-link>
        </div>

        <div class="category-analysis">
          <h3>根据营业额分类统计</h3>
          <div class="chart-placeholder">
            <canvas id="BarChart"></canvas>
          </div>
        </div>

      </section>
  
      
    

      <!-- 具体商家分析模块 -->
      <section class="specific-analysis">
        <h2>具体商家分析</h2>
        <div class="merchant-selection">
          <label for="merchant-id">输入商家 ID:</label>
          <input
            id="merchant-id"
            type="text"
            v-model="merchantId"
            placeholder="例如：1001"
          />
          <button @click="analyzeMerchant">分析</button>
        </div>

        
        <div v-if="merchantData" class="merchant-details">

            
          <h3>商家 ID: {{ merchantId }}</h3>



            <div class="stat-details">
                <div class="info-cards">
                    <router-link to="/" class="info-card cyan">
                        <h2>新用户数量</h2>
                        <p>{{ merchantData.newUsers }}</p>
                    </router-link>
                
                    <router-link to="/" class="info-card yellow">
                        <h2>用户流失数量</h2>
                        <p>{{ merchantData.churnedUsers }}</p>
                    </router-link>
                    <router-link to="/" class="info-card cyan">
                        <h2><div class="">可能流失用户预测</div></h2>
                        <p>{{ merchantData.predictedChurn }}</p>
                    </router-link>
                </div>

            </div>
          <div class="chart-placeholder">[商家分析图表]</div>
        </div>
      </section>
    </main>
  </template>
  
  <script>
  import { onMounted } from "vue";
  import Chart from "chart.js/auto";
  export default {
    name: "MchAnalysis",
    data() {
      return {
        merchantId: "",
        merchantData: null, // 保存具体商家数据
      };
    },
    methods: {
      // 模拟获取商家分析数据
      analyzeMerchant() {
        if (!this.merchantId) {
          alert("请输入商家 ID！");
          return;
        }
  
        // 假设从后端或已有数据中获取商家分析结果
        this.merchantData = {
          newUsers: Math.floor(Math.random() * 100),
          churnedUsers: Math.floor(Math.random() * 50),
          predictedChurn: Math.floor(Math.random() * 20),
        };
      },
    },
    setup(){
    onMounted(() => {
      new Chart(document.getElementById("BarChart"), {
        type: "bar",
        data: {
          labels: ["0-250", "250-500", "500-750", "750-1000"],
          datasets: [
            {
              label: "商家数量",
              data: [300, 220, 325, 175],
              backgroundColor: "#3498db",
            },
          ],
        },
        options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true,
            },
          },
        },
      });
    });
    }
  }

  </script>
  <style scoped>
  
  /* 主体内容样式 */
  .main-content {
    flex: 1;
    background: #f6faff;
    padding: 20px;
  }
  
  .main-content h1 {
    font-size: 24px;
    margin-bottom: 20px;
    color: #34495e;
  }
  
  .analysis-overview {
    display: flex;
    gap: 20px;
    margin-bottom: 30px;
  }
  
  .stat-card {
    flex: 1;
    background: #ffffff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    text-align: center;
  }
  
  .stat-card h2 {
    font-size: 16px;
    margin-bottom: 10px;
    color: #555;
  }
  
  .stat-card p {
    font-size: 24px;
    font-weight: bold;
    color: #27ae60;
  }
  
  .analysis-details {
    background: #ffffff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .analysis-details h2 {
    font-size: 18px;
    margin-bottom: 10px;
    color: #34495e;
  }
  
  .analysis-details p {
    font-size: 14px;
    color: #777;
    margin-bottom: 20px;
  }
  
  .chart-placeholder {
    height: 300px;
    background: #ecf0f1;
    border-radius: 8px;
    display: flex;
    justify-content: center;
    align-items: center;
    color: #95a5a6;
    font-size: 16px;
  }

  .info-cards {
    display: flex;
    justify-content: space-between;
    align-items: stretch;
    flex-wrap: wrap;
  }
  
  .info-card {
    flex: 1;
    margin: 10px;
    padding: 10px;
    border-radius: 10px;
    color: white;
    text-align: center;
    display: flex;
    flex-direction: column;
    justify-content: center;
    transition: transform 0.3s ease-in-out;
    text-decoration: none;
  }
  
  .info-card:hover {
    transform: translateY(-10px);
  }
  
  .info-card h2 {
    font-size: 1rem;
  }
  
  .info-card p {
    font-size: 1.6rem;
    margin: 8px 0;
  }
  .cyan {
    background-color: #1abc9c;
  }
  
  .green {
    background-color: #2ecc71;
  }
  
  .yellow {
    background-color: #f1c40f;
  }
  
  .purple {
    background-color: #9b59b6;
  }
  </style>