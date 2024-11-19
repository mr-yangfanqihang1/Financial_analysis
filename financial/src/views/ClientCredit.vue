<template>
  <div class="container">
    <!-- 用户信息 -->
    <div class="user-info">
      <h1>用户基本信息</h1>
      <div class="info-card">
        <p><strong>姓名：</strong>{{ userInfo.name }}</p>
        <p><strong>账户类型：</strong>{{ userInfo.accountType }}</p>
        <p><strong>账户状态：</strong>{{ userInfo.accountStatus }}</p>
      </div>
    </div>

    <!-- 信用评分 -->
    <div class="section">
      <h2>用户信用评分</h2>
      <div class="chart-container">
        <canvas id="creditScoreChart"></canvas>
      </div>
    </div>

    <!-- 信用评分历史趋势 -->
    <div class="section">
      <h2>信用评分历史趋势</h2>
      <div class="chart-container">
        <canvas id="creditScoreTrendChart"></canvas>
      </div>
    </div>

    <!-- 负债分析 -->
    <div class="section">
      <h2>负债比率与还款计划</h2>
      <div class="chart-container">
        <canvas id="debtIncomeRatioChart"></canvas>
      </div>
    </div>

    <!-- 个人风险评估 -->
    <div class="section">
      <h2>个人风险评估</h2>
      <div class="risk-card">
        <p><strong>风险等级：</strong>{{ riskLevel }}</p>
        <p v-if="riskLevel === '高风险'">建议尽量减少借贷，并增加收入。</p>
        <p v-if="riskLevel === '中风险'">请注意控制支出，并适当降低负债。</p>
        <p v-if="riskLevel === '低风险'">目前财务状况良好，请继续保持。</p>
      </div>
    </div>

    <!-- 财务健康建议 -->
    <div class="section">
      <h2>财务健康建议</h2>
      <div class="advice-card">
        <p>根据您的当前财务状况，建议您：<br>
          - 定期查看信用报告<br>
          - 优化支出结构<br>
          - 增加紧急储蓄
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import { onMounted, ref } from 'vue'
import Chart from 'chart.js/auto'

export default {
  name: 'CreditAnalysis',
  setup() {
    // 用户基本信息
    const userInfo = ref({
      name: '张三',
      accountType: '普通用户',
      accountStatus: '正常'
    })

    // 信用评分数据
    const creditScoreData = ref({
      labels: ['信用评分', '空白'],
      datasets: [
        {
          label: '信用评分',
          data: [750, 100 - 750 / 850 * 100], // 假设信用评分为750，最大850
          backgroundColor: ['#4CAF50', '#E0E0E0'],
          borderWidth: 1
        }
      ]
    })

    // 信用评分历史趋势数据
    const creditScoreTrendData = ref({
      labels: ['2021年', '2022年', '2023年', '2024年'],
      datasets: [
        {
          label: '信用评分历史',
          data: [750, 780, 790, 750],
          borderColor: '#42A5F5',
          backgroundColor: 'rgba(66, 165, 245, 0.2)',
          fill: true,
          tension: 0.4
        }
      ]
    })

    // 负债比率数据
    const debtIncomeRatioData = ref({
      labels: ['负债比率'],
      datasets: [
        {
          label: '负债比率',
          data: [35], // 假设负债比率为35%
          backgroundColor: '#FF7043',
          borderWidth: 1
        }
      ]
    })

    // 个人风险评估等级
    const riskLevel = ref('中风险')

    // 配置选项
    const chartOptions = {
      responsive: true,
      maintainAspectRatio: false,
      plugins: {
        legend: {
          position: 'top',
        }
      },
      scales: {
        y: {
          min: 0,
          max: 100, // 对于百分比的图表设置最大值为100
        },
        x: {
          beginAtZero: true
        }
      }
    }

    // 图表初始化
    onMounted(() => {
      // 信用评分图表
      new Chart(document.getElementById('creditScoreChart'), {
        type: 'pie',
        data: creditScoreData.value,
        options: chartOptions,
      })

      // 信用评分历史趋势图表
      new Chart(document.getElementById('creditScoreTrendChart'), {
        type: 'line',
        data: creditScoreTrendData.value,
        options: chartOptions,
      })

      // 负债比率图表
      new Chart(document.getElementById('debtIncomeRatioChart'), {
        type: 'bar',
        data: debtIncomeRatioData.value,
        options: chartOptions,
      })
    })

    return { userInfo, creditScoreData, creditScoreTrendData, debtIncomeRatioData, riskLevel, chartOptions }
  }
}
</script>

<style scoped>
/* 背景渐变流动，朝一个方向流动，并且无缝循环 */
@keyframes gradientMovement {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

.container {
  max-width: 1200px;
  margin: auto;
  padding: 20px;
  background: linear-gradient(45deg, #ff6a00, #ff3d00, #ff62a5, #4facfe, #ff007f, #c471ed, #00d2ff, #ff7e5f);
  background-size: 200% 200%;  /* 扩展渐变区域，确保流动效果足够平滑 */
  animation: gradientMovement 6s ease infinite; /* 流动速度加快且无缝循环 */
  border-radius: 20px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

/* 用户信息卡片 */
.user-info {
  margin-bottom: 40px;
  text-align: center;
}

.info-card {
  background-color: #fff;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  margin-top: 20px;
}

/* 每个部分的布局 */
.section {
  margin-bottom: 40px;
  text-align: center;
}

/* 图表容器样式 */
.chart-container {
  position: relative;
  width: 100%;
  height: 400px;
  margin-top: 20px;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  overflow: hidden;
  transition: all 0.3s ease-in-out;
}

.chart-container:hover {
  transform: translateY(-5px);
  box-shadow: 0 6px 25px rgba(0, 0, 0, 0.2);
}

/* 风险评估 */
.risk-card, .advice-card {
  background-color: #fff;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  margin-top: 20px;
}

/* 标题样式 */
h2, h1 {
  font-family: 'Arial', sans-serif;
  font-size: 24px;
  font-weight: 600;
  color: #333;
  margin-bottom: 20px;
}

h1 {
  font-size: 28px;
  font-weight: bold;
  color: #333;
  margin-bottom: 40px;
}

/* 响应式设计 */
@media screen and (max-width: 768px) {
  .container {
    padding: 15px;
  }

  .chart-container {
    height: 300px;
  }

  h2 {
    font-size: 20px;
  }

  h1 {
    font-size: 24px;
  }
}
</style>
