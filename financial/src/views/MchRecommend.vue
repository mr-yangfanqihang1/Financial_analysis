
<!--<template>-->
<!--  <div class="merchant-recommendation">-->
<!--    <h2>推荐用户</h2>-->

<!--    &lt;!&ndash; 搜索框 &ndash;&gt;-->
<!--    <div class="search-container">-->
<!--      <input-->
<!--          type="text"-->
<!--          v-model="searchQuery"-->
<!--          placeholder="请输入商户ID搜索感兴趣的用户"-->
<!--          @input="filterMerchants"-->
<!--      />-->
<!--    </div>-->

<!--    <div class="merchant-list">-->
<!--      <div v-for="merchant in filteredMerchants" :key="merchant.id" class="merchant-item">-->
<!--        <div class="merchant-content">-->
<!--          <img :src="merchant.logo" :alt="`${merchant.name} logo`" class="merchant-logo" />-->
<!--          <h3>{{ merchant.name }}</h3>-->
<!--          <p>{{ merchant.description }}</p>-->
<!--          <button @click="visitMerchant(merchant.link)">了解更多</button>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: 'MerchantRecommendation',-->
<!--  data () {-->
<!--    return {-->
<!--      searchQuery: '', // 用户输入的搜索ID-->
<!--      merchants: [-->
<!--        {-->
<!--          id: 1,-->
<!--          name: '用户甲',-->
<!--          description: '喜欢小动物',-->
<!--          logo: 'https://example.com/merchant-logo-a.jpg',-->
<!--          link: 'https://example.com/merchant-a'-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          name: '用户乙',-->
<!--          description: '交易诚信',-->
<!--          logo: 'https://example.com/merchant-logo-b.jpg',-->
<!--          link: 'https://example.com/merchant-b'-->
<!--        },-->
<!--        {-->
<!--          id: 3,-->
<!--          name: '用户丙',-->
<!--          description: '喜欢玩具',-->
<!--          logo: 'https://example.com/merchant-logo-c.jpg',-->
<!--          link: 'https://example.com/merchant-c'-->
<!--        }-->
<!--      ],-->
<!--      filteredMerchants: [] // 用于存储筛选后的商户列表-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    visitMerchant (link) {-->
<!--      window.open(link, '_blank')-->
<!--    },-->
<!--    filterMerchants() {-->
<!--      if (this.searchQuery === '') {-->
<!--        // 如果没有输入ID，则显示所有商户-->
<!--        this.filteredMerchants = this.merchants;-->
<!--      } else {-->
<!--        // 根据用户输入的ID筛选商户-->
<!--        const userId = parseInt(this.searchQuery, 10);-->
<!--        this.filteredMerchants = this.merchants.filter(merchant => merchant.id === userId);-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  created() {-->
<!--    // 初始化时展示所有商户-->
<!--    this.filteredMerchants = this.merchants;-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--html, body {-->
<!--  height: 100%;-->
<!--  margin: 0;-->
<!--  font-family: 'Arial', sans-serif;-->
<!--}-->

<!--.merchant-recommendation {-->
<!--  min-height: 100vh;-->
<!--  padding: 20px;-->
<!--  background: linear-gradient(135deg, #6a85b6, #bac8e0, #ff79c6);-->
<!--  color: #333;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  align-items: center;-->
<!--}-->

<!--h2 {-->
<!--  text-align: center;-->
<!--  font-size: 2rem;-->
<!--  margin-bottom: 30px;-->
<!--  color: #ffffff;-->
<!--}-->

<!--.search-container {-->
<!--  margin-bottom: 20px;-->
<!--  display: flex;-->
<!--  justify-content: center;-->
<!--}-->

<!--input {-->
<!--  padding: 12px 20px;-->
<!--  width: 100%;-->
<!--  max-width: 1200px; /* 拉长搜索框 */-->
<!--  border: 2px solid #ccc;-->
<!--  border-radius: 8px;-->
<!--  font-size: 1rem;-->
<!--  transition: border-color 0.3s ease;-->
<!--}-->

<!--input:focus {-->
<!--  border-color: #007bff;-->
<!--  outline: none;-->
<!--}-->

<!--.merchant-list {-->
<!--  width: 100%;-->
<!--  max-width: 1200px;-->
<!--  display: grid;-->
<!--  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));-->
<!--  gap: 20px;-->
<!--  justify-items: center;  /* 水平居中 */-->
<!--  align-items: center;    /* 垂直居中 */-->
<!--}-->

<!--.merchant-item {-->
<!--  width: 280px;  /* 固定卡片宽度 */-->
<!--  height: 380px; /* 固定卡片高度 */-->
<!--  background: #ffffff;-->
<!--  border-radius: 16px;-->
<!--  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);-->
<!--  overflow: hidden;-->
<!--  transition: transform 0.3s ease, box-shadow 0.3s ease;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  justify-content: space-between; /* 让卡片内的内容均匀分布 */-->
<!--}-->

<!--.merchant-item:hover {-->
<!--  transform: translateY(-5px);-->
<!--  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);-->
<!--}-->

<!--.merchant-content {-->
<!--  padding: 20px;-->
<!--  text-align: center;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  justify-content: space-between;-->
<!--  height: 100%; /* 让内容填充整个卡片 */-->
<!--}-->

<!--.merchant-logo {-->
<!--  width: 80px;-->
<!--  height: 80px;-->
<!--  object-fit: cover;-->
<!--  border-radius: 50%;-->
<!--  margin-bottom: 15px;-->
<!--  transition: transform 0.3s ease;-->
<!--}-->

<!--.merchant-item:hover .merchant-logo {-->
<!--  transform: scale(1.1);-->
<!--}-->

<!--.merchant-info h3 {-->
<!--  font-size: 1.4em;-->
<!--  margin-bottom: 10px;-->
<!--  color: #333;-->
<!--  font-weight: 600;-->
<!--}-->

<!--.merchant-info p {-->
<!--  font-size: 1em;-->
<!--  color: #666;-->
<!--  margin-bottom: 15px;-->
<!--  line-height: 1.6;-->
<!--}-->

<!--button {-->
<!--  background-color: #007bff;-->
<!--  color: #ffffff;-->
<!--  border: none;-->
<!--  padding: 10px 25px;-->
<!--  border-radius: 30px;-->
<!--  cursor: pointer;-->
<!--  font-size: 1rem;-->
<!--  transition: background-color 0.3s ease, transform 0.2s ease;-->
<!--}-->

<!--button:hover {-->
<!--  background-color: #0056b3;-->
<!--  transform: scale(1.05);-->
<!--}-->

<!--button:active {-->
<!--  background-color: #003f7f;-->
<!--}-->
<!--</style>-->



<!--<template>-->
<!--  <div class="merchant-recommendation">-->
<!--    <h2>推荐用户</h2>-->

<!--    &lt;!&ndash; 搜索框 &ndash;&gt;-->
<!--    <div class="search-container">-->
<!--      <input-->
<!--          type="text"-->
<!--          v-model="searchQuery"-->
<!--          placeholder="请输入商户ID搜索感兴趣的用户"-->
<!--          @input="filterMerchants"-->
<!--      />-->
<!--    </div>-->

<!--    &lt;!&ndash; 图表区域 &ndash;&gt;-->
<!--    <div class="chart-container">-->
<!--      <BarChart :data="chartData" :options="chartOptions" />-->
<!--    </div>-->

<!--    <div class="merchant-list">-->
<!--      <div v-for="merchant in filteredMerchants" :key="merchant.id" class="merchant-item">-->
<!--        <div class="merchant-content">-->
<!--          <img :src="merchant.logo" :alt="`${merchant.name} logo`" class="merchant-logo" />-->
<!--          <h3>{{ merchant.name }}</h3>-->
<!--          <p>{{ merchant.description }}</p>-->
<!--          <button @click="visitMerchant(merchant.link)">了解更多</button>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--import { Bar } from 'vue-chartjs';-->
<!--import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';-->

<!--ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);-->

<!--export default {-->
<!--  name: 'MerchantRecommendation',-->
<!--  components: {-->
<!--    BarChart: Bar-->
<!--  },-->
<!--  data () {-->
<!--    return {-->
<!--      searchQuery: '', // 用户输入的搜索ID-->
<!--      merchants: [-->
<!--        {-->
<!--          id: 1,-->
<!--          name: '用户甲',-->
<!--          description: '喜欢小动物',-->
<!--          logo: 'https://example.com/merchant-logo-a.jpg',-->
<!--          link: 'https://example.com/merchant-a',-->
<!--          recommendedUsers: 15-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          name: '用户乙',-->
<!--          description: '交易诚信',-->
<!--          logo: 'https://example.com/merchant-logo-b.jpg',-->
<!--          link: 'https://example.com/merchant-b',-->
<!--          recommendedUsers: 30-->
<!--        },-->
<!--        {-->
<!--          id: 3,-->
<!--          name: '用户丙',-->
<!--          description: '喜欢玩具',-->
<!--          logo: 'https://example.com/merchant-logo-c.jpg',-->
<!--          link: 'https://example.com/merchant-c',-->
<!--          recommendedUsers: 25-->
<!--        }-->
<!--      ],-->
<!--      filteredMerchants: [], // 用于存储筛选后的商户列表-->

<!--      // 图表数据-->
<!--      chartData: {-->
<!--        labels: ['用户甲', '用户乙', '用户丙'],  // 商户名字作为标签-->
<!--        datasets: [-->
<!--          {-->
<!--            label: '推荐用户数量',-->
<!--            data: [15, 30, 25],  // 每个商户推荐的用户数量-->
<!--            backgroundColor: ['#42A5F5', '#66BB6A', '#FF7043'],-->
<!--            borderColor: ['#1E88E5', '#43A047', '#FF5722'],-->
<!--            borderWidth: 1-->
<!--          }-->
<!--        ]-->
<!--      },-->

<!--      // 图表配置-->
<!--      chartOptions: {-->
<!--        responsive: true,-->
<!--        plugins: {-->
<!--          legend: {-->
<!--            position: 'top',-->
<!--          },-->
<!--          title: {-->
<!--            display: true,-->
<!--            text: '每个商户的推荐用户数量'-->
<!--          }-->
<!--        },-->
<!--        scales: {-->
<!--          y: {-->
<!--            beginAtZero: true-->
<!--          }-->
<!--        }-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    visitMerchant (link) {-->
<!--      window.open(link, '_blank')-->
<!--    },-->
<!--    filterMerchants() {-->
<!--      if (this.searchQuery === '') {-->
<!--        // 如果没有输入ID，则显示所有商户-->
<!--        this.filteredMerchants = this.merchants;-->
<!--      } else {-->
<!--        // 根据用户输入的ID筛选商户-->
<!--        const userId = parseInt(this.searchQuery, 10);-->
<!--        this.filteredMerchants = this.merchants.filter(merchant => merchant.id === userId);-->
<!--      }-->

<!--      // 更新图表数据（根据筛选后的商户更新推荐用户数量）-->
<!--      this.updateChartData();-->
<!--    },-->
<!--    updateChartData() {-->
<!--      // 生成图表所需的数据-->
<!--      const labels = this.filteredMerchants.map(merchant => merchant.name);-->
<!--      const data = this.filteredMerchants.map(merchant => merchant.recommendedUsers);-->

<!--      // 更新图表数据-->
<!--      this.chartData.labels = labels;-->
<!--      this.chartData.datasets[0].data = data;-->
<!--    }-->
<!--  },-->
<!--  created() {-->
<!--    // 初始化时展示所有商户-->
<!--    this.filteredMerchants = this.merchants;-->
<!--    this.updateChartData();-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--html, body {-->
<!--  height: 100%;-->
<!--  margin: 0;-->
<!--  font-family: 'Arial', sans-serif;-->
<!--}-->

<!--.merchant-recommendation {-->
<!--  min-height: 100vh;-->
<!--  padding: 20px;-->
<!--  background: linear-gradient(135deg, #6a85b6, #bac8e0, #ff79c6);-->
<!--  color: #333;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  align-items: center;-->
<!--}-->

<!--h2 {-->
<!--  text-align: center;-->
<!--  font-size: 2rem;-->
<!--  margin-bottom: 30px;-->
<!--  color: #ffffff;-->
<!--}-->

<!--.search-container {-->
<!--  margin-bottom: 20px;-->
<!--  display: flex;-->
<!--  justify-content: center;-->
<!--}-->

<!--input {-->
<!--  padding: 12px 20px;-->
<!--  width: 100%;-->
<!--  max-width: 1200px; /* 拉长搜索框 */-->
<!--  border: 2px solid #ccc;-->
<!--  border-radius: 8px;-->
<!--  font-size: 1rem;-->
<!--  transition: border-color 0.3s ease;-->
<!--}-->

<!--input:focus {-->
<!--  border-color: #007bff;-->
<!--  outline: none;-->
<!--}-->

<!--.chart-container {-->
<!--  width: 100%;-->
<!--  max-width: 1200px;-->
<!--  margin-bottom: 30px;-->
<!--  display: flex;-->
<!--  justify-content: center;-->
<!--}-->

<!--.merchant-list {-->
<!--  width: 100%;-->
<!--  max-width: 1200px;-->
<!--  display: grid;-->
<!--  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));-->
<!--  gap: 20px;-->
<!--  justify-items: center;  /* 水平居中 */-->
<!--  align-items: center;    /* 垂直居中 */-->
<!--}-->

<!--.merchant-item {-->
<!--  width: 280px;  /* 固定卡片宽度 */-->
<!--  height: 380px; /* 固定卡片高度 */-->
<!--  background: #ffffff;-->
<!--  border-radius: 16px;-->
<!--  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);-->
<!--  overflow: hidden;-->
<!--  transition: transform 0.3s ease, box-shadow 0.3s ease;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  justify-content: space-between; /* 让卡片内的内容均匀分布 */-->
<!--}-->

<!--.merchant-item:hover {-->
<!--  transform: translateY(-5px);-->
<!--  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);-->
<!--}-->

<!--.merchant-content {-->
<!--  padding: 20px;-->
<!--  text-align: center;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  justify-content: space-between;-->
<!--  height: 100%; /* 让内容填充整个卡片 */-->
<!--}-->

<!--.merchant-logo {-->
<!--  width: 80px;-->
<!--  height: 80px;-->
<!--  object-fit: cover;-->
<!--  border-radius: 50%;-->
<!--  margin-bottom: 15px;-->
<!--  transition: transform 0.3s ease;-->
<!--}-->

<!--.merchant-item:hover .merchant-logo {-->
<!--  transform: scale(1.1);-->
<!--}-->

<!--.merchant-info h3 {-->
<!--  font-size: 1.4em;-->
<!--  margin-bottom: 10px;-->
<!--  color: #333;-->
<!--  font-weight: 600;-->
<!--}-->

<!--.merchant-info p {-->
<!--  font-size: 1em;-->
<!--  color: #666;-->
<!--  margin-bottom: 15px;-->
<!--  line-height: 1.6;-->
<!--}-->

<!--button {-->
<!--  background-color: #007bff;-->
<!--  color: #ffffff;-->
<!--  border: none;-->
<!--  padding: 10px 25px;-->
<!--  border-radius: 30px;-->
<!--  cursor: pointer;-->
<!--  font-size: 1rem;-->
<!--  transition: background-color 0.3s ease, transform 0.2s ease;-->
<!--}-->

<!--button:hover {-->
<!--  background-color: #0056b3;-->
<!--  transform: scale(1.05);-->
<!--}-->

<!--button:active {-->
<!--  background-color: #003f7f;-->
<!--}-->
<!--</style>-->

<template>
  <div class="merchant-recommendation">
    <h2>推荐用户</h2>

    <!-- 搜索框 -->
    <div class="search-container">
      <input
          type="text"
          v-model="searchQuery"
          placeholder="请输入商户ID搜索感兴趣的用户"
          @input="filterUsersByMerchant"
      />
    </div>

    <!-- 柱状图 -->
    <div class="chart-container">
      <canvas ref="barChart"></canvas>
    </div>

    <!-- 圆形统计图 -->
    <div class="chart-container">
      <canvas ref="pieChart"></canvas>
    </div>

    <!-- 推荐的用户卡片 -->
    <div class="merchant-list">
      <div v-for="user in filteredUsers" :key="user.id" class="merchant-item">
        <div class="merchant-content">
          <img :src="user.logo" :alt="`${user.name} logo`" class="merchant-logo" />
          <h3>{{ user.name }}</h3>
          <p>{{ user.description }}</p>
          <button @click="visitUser(user.link)">了解更多</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// 引入 Chart.js
import { Chart } from 'chart.js';

export default {
  name: 'MerchantRecommendation',
  data() {
    return {
      searchQuery: '', // 用户输入的商户ID
      merchants: [
        { id: 1, name: '商家甲', description: '提供高质量的电子产品', logo: 'https://example.com/logo-a.jpg', link: 'https://example.com/a' },
        { id: 2, name: '商家乙', description: '提供精美饰品', logo: 'https://example.com/logo-b.jpg', link: 'https://example.com/b' },
        { id: 3, name: '商家丙', description: '提供高端服装', logo: 'https://example.com/logo-c.jpg', link: 'https://example.com/c' },
      ],
      users: [
        { id: 1, name: '用户甲', description: '喜欢电子产品', logo: 'https://example.com/user-a.jpg', link: 'https://example.com/user-a', merchantId: 1 },
        { id: 2, name: '用户乙', description: '钟情饰品', logo: 'https://example.com/user-b.jpg', link: 'https://example.com/user-b', merchantId: 2 },
        { id: 3, name: '用户丙', description: '热爱服装', logo: 'https://example.com/user-c.jpg', link: 'https://example.com/user-c', merchantId: 3 },
        { id: 4, name: '用户丁', description: '喜欢电子产品', logo: 'https://example.com/user-d.jpg', link: 'https://example.com/user-d', merchantId: 1 },
        { id: 5, name: '用户戊', description: '喜欢饰品', logo: 'https://example.com/user-e.jpg', link: 'https://example.com/user-e', merchantId: 2 },
        { id: 6, name: '用户己', description: '关注服装', logo: 'https://example.com/user-f.jpg', link: 'https://example.com/user-f', merchantId: 3 },
      ],
      filteredUsers: [], // 用于存储筛选后的用户列表
      chartData: [
        { name: '商家甲', value: 2 }, // 用户甲和用户丁对商家甲感兴趣
        { name: '商家乙', value: 2 }, // 用户乙和用户戊对商家乙感兴趣
        { name: '商家丙', value: 2 }, // 用户丙和用户己对商家丙感兴趣
      ],
    };
  },
  methods: {
    filterUsersByMerchant() {
      const merchantId = parseInt(this.searchQuery, 10);
      if (!merchantId || isNaN(merchantId)) {
        this.filteredUsers = [];
        return;
      }
      // 筛选出感兴趣该商家的用户
      this.filteredUsers = this.users.filter(user => user.merchantId === merchantId);
      this.updateCharts();
    },
    visitUser(link) {
      window.open(link, '_blank');
    },
    updateCharts() {
      // 更新柱状图
      const barChartContext = this.$refs.barChart.getContext('2d');
      if (this.barChart) {
        this.barChart.destroy();
      }
      this.barChart = new Chart(barChartContext, {
        type: 'bar',
        data: {
          labels: this.merchants.map(merchant => merchant.name),
          datasets: [{
            label: '感兴趣的用户数',
            data: this.chartData.map(data => data.value),
            backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
            borderColor: ['#4e73df', '#1cc88a', '#36b9cc'],
            borderWidth: 1
          }]
        },
        options: {
          scales: {
            y: {
              beginAtZero: true,
            }
          },
        }
      });

      // 更新圆形统计图
      const pieChartContext = this.$refs.pieChart.getContext('2d');
      if (this.pieChart) {
        this.pieChart.destroy();
      }
      this.pieChart = new Chart(pieChartContext, {
        type: 'pie',
        data: {
          labels: this.merchants.map(merchant => merchant.name),
          datasets: [{
            data: this.chartData.map(data => data.value),
            backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
            hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
            hoverBorderColor: '#ffffff'
          }]
        }
      });
    }
  },
  created() {
    // 初始化时展示所有用户并生成图表
    this.filteredUsers = this.users;
    this.updateCharts();
  }
};
</script>

<style scoped>
html, body {
  height: 100%;
  margin: 0;
  font-family: 'Arial', sans-serif;
}

.merchant-recommendation {
  min-height: 100vh;
  padding: 20px;
  background: linear-gradient(135deg, #6a85b6, #bac8e0, #ff79c6);
  color: #333;
  display: flex;
  flex-direction: column;
  align-items: center;
}

h2 {
  text-align: center;
  font-size: 2rem;
  margin-bottom: 30px;
  color: #ffffff;
}

.search-container {
  margin-bottom: 20px;
  display: flex;
  justify-content: center;
}

input {
  padding: 12px 20px;
  width: 100%;
  max-width: 1200px; /* 拉长搜索框 */
  border: 2px solid #ccc;
  border-radius: 8px;
  font-size: 1rem;
  transition: border-color 0.3s ease;
}

input:focus {
  border-color: #007bff;
  outline: none;
}

.chart-container {
  width: 80%;
  max-width: 1200px;
  margin: 40px 0;
}

.merchant-list {
  width: 100%;
  max-width: 1200px;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 20px;
  justify-items: center;  /* 水平居中 */
  align-items: center;    /* 垂直居中 */
}

.merchant-item {
  width: 280px;  /* 固定卡片宽度 */
  height: 380px; /* 固定卡片高度 */
  background: #ffffff;
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  display: flex;
  flex-direction: column;
  justify-content: space-between; /* 让卡片内的内容均匀分布 */
}

.merchant-item:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
}

.merchant-content {
  padding: 20px;
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 100%; /* 让内容填充整个卡片 */
}

.merchant-logo {
  width: 80px;
  height: 80px;
  object-fit: cover;
  border-radius: 50%;
  margin-bottom: 15px;
  transition: transform 0.3s ease;
}

.merchant-item:hover .merchant-logo {
  transform: scale(1.1);
}

button {
  background-color: #007bff;
  color: #ffffff;
  border: none;
  padding: 10px 25px;
  border-radius: 30px;
  cursor: pointer;
  font-size: 1rem;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

button:hover {
  background-color: #0056b3;
  transform: scale(1.05);
}

button:active {
  background-color: #003f7f;
}
</style>
