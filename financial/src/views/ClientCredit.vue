<template>
  <div class="container">
    <!-- Credit Score Section -->
    <div class="section">
      <h2>用户信用评分</h2>
      <LineChart :chartData="creditScoreData" />
    </div>

    <!-- Debt-to-Income Ratio Section -->
    <div class="section">
      <h2>负债比率</h2>
      <BarChart :chartData="debtIncomeRatioData" />
    </div>

    <!-- Repayment History Section -->
    <div class="section">
      <h2>还款历史</h2>
      <DoughnutChart :chartData="repaymentHistoryData" />
    </div>
  </div>
</template>

<script>
import { defineComponent } from 'vue'
import { Line, Bar, Doughnut } from 'vue-chartjs'
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend, ArcElement, LineElement } from 'chart.js'

// 注册 Chart.js 所需的插件
ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend, ArcElement, LineElement)

export default defineComponent({
  name: 'CreditAnalysis',
  components: {
    LineChart: Line,
    BarChart: Bar,
    DoughnutChart: Doughnut
  },
  data () {
    return {
      creditScoreData: {
        labels: ['信用评分', '空白'],
        datasets: [
          {
            label: '信用评分',
            data: [750, 100 - 750 / 850 * 100], // 假设信用评分为750，最大850
            backgroundColor: ['#4CAF50', '#E0E0E0'],
            borderWidth: 1
          }
        ]
      },
      debtIncomeRatioData: {
        labels: ['负债比率'],
        datasets: [
          {
            label: '负债比率',
            data: [35], // 假设负债比率为35%
            backgroundColor: '#FF7043',
            borderWidth: 1
          }
        ]
      },
      repaymentHistoryData: {
        labels: ['1月', '2月', '3月', '4月', '5月', '6月', '7月'],
        datasets: [
          {
            label: '还款历史 (%)',
            data: [80, 90, 100, 70, 50, 90, 60],
            borderColor: '#42A5F5',
            backgroundColor: 'rgba(66, 165, 245, 0.2)',
            fill: true,
            tension: 0.4
          }
        ]
      }
    }
  }
})
</script>

<style scoped>
.container {
  max-width: 1200px;
  margin: auto;
  padding: 20px;
}

.section {
  margin-bottom: 30px;
}

canvas {
  max-width: 100%;
  height: auto;
}

h2 {
  text-align: center;
  color: #333;
}
</style>
