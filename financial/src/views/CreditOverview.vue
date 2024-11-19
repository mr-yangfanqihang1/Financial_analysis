<template>
    <div class="container">
      <!-- 统计数据概览 -->
      <div class="overview">
        <h2>用户信誉总览</h2>
        <div class="stat-cards">
          <div class="stat-card">
            <h3>平均信用评分</h3>
            <p>{{ avgCreditScore }}</p>
          </div>
          <div class="stat-card">
            <h3>总负债比率</h3>
            <p>{{ avgDebtRatio }}%</p>
          </div>
          <div class="stat-card">
            <h3>平均还款历史</h3>
            <p>{{ avgRepaymentHistory }}%</p>
          </div>
        </div>
      </div>
  
      <!-- 信用评分分布图 -->
      <div class="chart-container">
        <h3>信用评分分布</h3>
        <canvas id="creditScoreDistributionChart"></canvas>
      </div>
  
      <!-- 用户信息概览列表 -->
      <div class="user-list">
        <h3>所有用户信息</h3>
        <table>
          <thead>
            <tr>
              <th>用户名</th>
              <th>信用评分</th>
              <th>负债比率</th>
              <th>还款历史</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="user in users" :key="user.id">
              <td>{{ user.username }}</td>
              <td>{{ user.creditScore }}</td>
              <td>{{ user.debtRatio }}%</td>
              <td>{{ user.repaymentHistory }}%</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </template>
  
  <script>
  import { onMounted, ref } from 'vue'
  import Chart from 'chart.js/auto'
  
  export default {
    name: 'CreditOverview',
    setup() {
      // 模拟数据
      const users = ref([
        { id: 1, username: 'user1', creditScore: 750, debtRatio: 35, repaymentHistory: 80 },
        { id: 2, username: 'user2', creditScore: 680, debtRatio: 40, repaymentHistory: 90 },
        { id: 3, username: 'user3', creditScore: 720, debtRatio: 30, repaymentHistory: 85 },
        { id: 4, username: 'user4', creditScore: 800, debtRatio: 20, repaymentHistory: 95 },
        { id: 5, username: 'user5', creditScore: 650, debtRatio: 45, repaymentHistory: 70 },
      ])
  
      // 计算统计数据
      const avgCreditScore = ref(0)
      const avgDebtRatio = ref(0)
      const avgRepaymentHistory = ref(0)
  
      // 计算统计数据
      onMounted(() => {
        avgCreditScore.value = (users.value.reduce((acc, user) => acc + user.creditScore, 0) / users.value.length).toFixed(2)
        avgDebtRatio.value = (users.value.reduce((acc, user) => acc + user.debtRatio, 0) / users.value.length).toFixed(2)
        avgRepaymentHistory.value = (users.value.reduce((acc, user) => acc + user.repaymentHistory, 0) / users.value.length).toFixed(2)
  
        // 绘制信用评分分布图
        new Chart(document.getElementById('creditScoreDistributionChart'), {
          type: 'bar',
          data: {
            labels: users.value.map(user => user.username),
            datasets: [
              {
                label: '信用评分',
                data: users.value.map(user => user.creditScore),
                backgroundColor: '#42A5F5',
                borderColor: '#42A5F5',
                borderWidth: 1,
              },
            ],
          },
          options: {
            responsive: true,
            plugins: {
              legend: {
                position: 'top',
              },
            },
            scales: {
              y: {
                min: 0,
                max: 1000, // 假设信用评分最大为1000
              },
            },
          },
        })
      })
  
      return {
        users,
        avgCreditScore,
        avgDebtRatio,
        avgRepaymentHistory,
      }
    },
  }
  </script>
  
  <style scoped>
  /* 背景渐变 */
  .container {
    max-width: 1200px;
    margin: auto;
    padding: 20px;
    background: linear-gradient(135deg, #4facfe, #ff62a5); /* 渐变色背景 */
    border-radius: 20px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  }
  
  /* 标题样式 */
  h2 {
    font-size: 28px;
    font-weight: bold;
    color: #333;
    margin-bottom: 40px;
  }
  
  h3 {
    font-size: 22px;
    font-weight: 600;
    color: #333;
    margin-bottom: 20px;
  }
  
  /* 统计卡片 */
  .stat-cards {
    display: flex;
    justify-content: space-between;
  }
  
  .stat-card {
    background-color: #fff;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 30%;
  }
  
  .stat-card h3 {
    font-size: 20px;
    margin-bottom: 10px;
  }
  
  .stat-card p {
    font-size: 24px;
    font-weight: bold;
  }
  
  /* 图表容器 */
  .chart-container {
    background-color: #fff;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    margin-bottom: 40px;
  }
  
  canvas {
    width: 100% !important;
    height: 400px !important;
  }
  
  /* 用户信息列表 */
  .user-list {
    margin-top: 40px;
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
    border-radius: 12px;
    overflow: hidden;
  }
  
  th, td {
    padding: 15px;
    text-align: center;
    border-bottom: 1px solid #ddd;
  }
  
  th {
    background-color: #f4f4f4;
  }
  
  tr:hover {
    background-color: #f9f9f9;
  }
  
  /* 响应式设计 */
  @media screen and (max-width: 768px) {
    .container {
      padding: 15px;
    }
  
    .stat-card {
      width: 100%;
      margin-bottom: 20px;
    }
  
    canvas {
      height: 300px;
    }
  
    h2, h3 {
      font-size: 18px;
    }
  }
  </style>
  