<template>
    <!-- 主体内容 -->
    <main class="main-content">
      <h1>商家数据分析</h1>

      <!-- 整体统计分析模块 -->
      <section class="overall-analysis">
        <h2>整体统计分析</h2>
        <div class="overview-stats">
          <div class="stat-card">
            <h3>商家总数量</h3>
            <p>1234</p>
          </div>
          <div class="stat-card">
            <h3>商家总营业额</h3>
            <p>¥ 12,345,678</p>
          </div>
        </div>
        <div class="category-analysis">
          <h3>根据营业额分类统计</h3>
          <div class="chart-placeholder">[柱状图]</div>
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
            <div class="stat-card">
              <h4>新用户数量</h4>
              <p>{{ merchantData.newUsers }}</p>
            </div>
            <div class="stat-card">
              <h4>用户流失数量</h4>
              <p>{{ merchantData.churnedUsers }}</p>
            </div>
            <div class="stat-card">
              <h4>可能流失用户预测</h4>
              <p>{{ merchantData.predictedChurn }}</p>
            </div>
          </div>
          <div class="chart-placeholder">[商家分析图表]</div>
        </div>
      </section>
    </main>
  </template>
  
  <script>
  
  
  export default {
    name: "MchAnalysis",
    components: {
  
    },
    data() {
      return {
       
        
      };
    },
    methods: {
      
    },
  };
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
  </style>