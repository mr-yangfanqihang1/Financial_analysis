
<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div class="merchant-recommendation">&ndash;&gt;-->
<!--&lt;!&ndash;    <h2>推荐用户</h2>&ndash;&gt;-->

<!--&lt;!&ndash;    &lt;!&ndash; 搜索框 &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <div class="search-container">&ndash;&gt;-->
<!--&lt;!&ndash;      <input&ndash;&gt;-->
<!--&lt;!&ndash;          type="text"&ndash;&gt;-->
<!--&lt;!&ndash;          v-model="searchQuery"&ndash;&gt;-->
<!--&lt;!&ndash;          placeholder="请输入商户ID搜索感兴趣的用户"&ndash;&gt;-->
<!--&lt;!&ndash;          @input="filterUsersByMerchant"&ndash;&gt;-->
<!--&lt;!&ndash;      />&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->

<!--&lt;!&ndash;    &lt;!&ndash; 柱状图 &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <div class="chart-container">&ndash;&gt;-->
<!--&lt;!&ndash;      <canvas ref="barChart"></canvas>&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->

<!--&lt;!&ndash;    &lt;!&ndash; 圆形统计图 &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <div class="chart-container">&ndash;&gt;-->
<!--&lt;!&ndash;      <canvas ref="pieChart"></canvas>&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->

<!--&lt;!&ndash;    &lt;!&ndash; 推荐的用户卡片 &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;    <div class="merchant-list">&ndash;&gt;-->
<!--&lt;!&ndash;      <div v-for="user in filteredUsers" :key="user.id" class="merchant-item">&ndash;&gt;-->
<!--&lt;!&ndash;        <div class="merchant-content">&ndash;&gt;-->
<!--&lt;!&ndash;          <img :src="user.logo" :alt="`${user.name} logo`" class="merchant-logo" />&ndash;&gt;-->
<!--&lt;!&ndash;          <h3>{{ user.name }}</h3>&ndash;&gt;-->
<!--&lt;!&ndash;          <p>{{ user.description }}</p>&ndash;&gt;-->
<!--&lt;!&ndash;          <button @click="visitUser(user.link)">了解更多</button>&ndash;&gt;-->
<!--&lt;!&ndash;        </div>&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;// 引入 Chart.js&ndash;&gt;-->
<!--&lt;!&ndash;import { Chart } from 'chart.js';&ndash;&gt;-->

<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  name: 'MerchantRecommendation',&ndash;&gt;-->
<!--&lt;!&ndash;  data() {&ndash;&gt;-->
<!--&lt;!&ndash;    return {&ndash;&gt;-->
<!--&lt;!&ndash;      searchQuery: '', // 用户输入的商户ID&ndash;&gt;-->
<!--&lt;!&ndash;      merchants: [&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 1, name: '商家甲', description: '提供高质量的电子产品', logo: 'https://example.com/logo-a.jpg', link: 'https://example.com/a' },&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 2, name: '商家乙', description: '提供精美饰品', logo: 'https://example.com/logo-b.jpg', link: 'https://example.com/b' },&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 3, name: '商家丙', description: '提供高端服装', logo: 'https://example.com/logo-c.jpg', link: 'https://example.com/c' },&ndash;&gt;-->
<!--&lt;!&ndash;      ],&ndash;&gt;-->
<!--&lt;!&ndash;      users: [&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 1, name: '用户甲', description: '喜欢电子产品', logo: 'https://example.com/user-a.jpg', link: 'https://example.com/user-a', merchantId: 1 },&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 2, name: '用户乙', description: '钟情饰品', logo: 'https://example.com/user-b.jpg', link: 'https://example.com/user-b', merchantId: 2 },&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 3, name: '用户丙', description: '热爱服装', logo: 'https://example.com/user-c.jpg', link: 'https://example.com/user-c', merchantId: 3 },&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 4, name: '用户丁', description: '喜欢电子产品', logo: 'https://example.com/user-d.jpg', link: 'https://example.com/user-d', merchantId: 1 },&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 5, name: '用户戊', description: '喜欢饰品', logo: 'https://example.com/user-e.jpg', link: 'https://example.com/user-e', merchantId: 2 },&ndash;&gt;-->
<!--&lt;!&ndash;        { id: 6, name: '用户己', description: '关注服装', logo: 'https://example.com/user-f.jpg', link: 'https://example.com/user-f', merchantId: 3 },&ndash;&gt;-->
<!--&lt;!&ndash;      ],&ndash;&gt;-->
<!--&lt;!&ndash;      filteredUsers: [], // 用于存储筛选后的用户列表&ndash;&gt;-->
<!--&lt;!&ndash;      chartData: [&ndash;&gt;-->
<!--&lt;!&ndash;        { name: '商家甲', value: 2 }, // 用户甲和用户丁对商家甲感兴趣&ndash;&gt;-->
<!--&lt;!&ndash;        { name: '商家乙', value: 2 }, // 用户乙和用户戊对商家乙感兴趣&ndash;&gt;-->
<!--&lt;!&ndash;        { name: '商家丙', value: 2 }, // 用户丙和用户己对商家丙感兴趣&ndash;&gt;-->
<!--&lt;!&ndash;      ],&ndash;&gt;-->
<!--&lt;!&ndash;    };&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  methods: {&ndash;&gt;-->
<!--&lt;!&ndash;    filterUsersByMerchant() {&ndash;&gt;-->
<!--&lt;!&ndash;      const merchantId = parseInt(this.searchQuery, 10);&ndash;&gt;-->
<!--&lt;!&ndash;      if (!merchantId || isNaN(merchantId)) {&ndash;&gt;-->
<!--&lt;!&ndash;        this.filteredUsers = [];&ndash;&gt;-->
<!--&lt;!&ndash;        return;&ndash;&gt;-->
<!--&lt;!&ndash;      }&ndash;&gt;-->
<!--&lt;!&ndash;      // 筛选出感兴趣该商家的用户&ndash;&gt;-->
<!--&lt;!&ndash;      this.filteredUsers = this.users.filter(user => user.merchantId === merchantId);&ndash;&gt;-->
<!--&lt;!&ndash;      this.updateCharts();&ndash;&gt;-->
<!--&lt;!&ndash;    },&ndash;&gt;-->
<!--&lt;!&ndash;    visitUser(link) {&ndash;&gt;-->
<!--&lt;!&ndash;      window.open(link, '_blank');&ndash;&gt;-->
<!--&lt;!&ndash;    },&ndash;&gt;-->
<!--&lt;!&ndash;    updateCharts() {&ndash;&gt;-->
<!--&lt;!&ndash;      // 更新柱状图&ndash;&gt;-->
<!--&lt;!&ndash;      const barChartContext = this.$refs.barChart.getContext('2d');&ndash;&gt;-->
<!--&lt;!&ndash;      if (this.barChart) {&ndash;&gt;-->
<!--&lt;!&ndash;        this.barChart.destroy();&ndash;&gt;-->
<!--&lt;!&ndash;      }&ndash;&gt;-->
<!--&lt;!&ndash;      this.barChart = new Chart(barChartContext, {&ndash;&gt;-->
<!--&lt;!&ndash;        type: 'bar',&ndash;&gt;-->
<!--&lt;!&ndash;        data: {&ndash;&gt;-->
<!--&lt;!&ndash;          labels: this.merchants.map(merchant => merchant.name),&ndash;&gt;-->
<!--&lt;!&ndash;          datasets: [{&ndash;&gt;-->
<!--&lt;!&ndash;            label: '感兴趣的用户数',&ndash;&gt;-->
<!--&lt;!&ndash;            data: this.chartData.map(data => data.value),&ndash;&gt;-->
<!--&lt;!&ndash;            backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],&ndash;&gt;-->
<!--&lt;!&ndash;            borderColor: ['#4e73df', '#1cc88a', '#36b9cc'],&ndash;&gt;-->
<!--&lt;!&ndash;            borderWidth: 1&ndash;&gt;-->
<!--&lt;!&ndash;          }]&ndash;&gt;-->
<!--&lt;!&ndash;        },&ndash;&gt;-->
<!--&lt;!&ndash;        options: {&ndash;&gt;-->
<!--&lt;!&ndash;          scales: {&ndash;&gt;-->
<!--&lt;!&ndash;            y: {&ndash;&gt;-->
<!--&lt;!&ndash;              beginAtZero: true,&ndash;&gt;-->
<!--&lt;!&ndash;            }&ndash;&gt;-->
<!--&lt;!&ndash;          },&ndash;&gt;-->
<!--&lt;!&ndash;        }&ndash;&gt;-->
<!--&lt;!&ndash;      });&ndash;&gt;-->

<!--&lt;!&ndash;      // 更新圆形统计图&ndash;&gt;-->
<!--&lt;!&ndash;      const pieChartContext = this.$refs.pieChart.getContext('2d');&ndash;&gt;-->
<!--&lt;!&ndash;      if (this.pieChart) {&ndash;&gt;-->
<!--&lt;!&ndash;        this.pieChart.destroy();&ndash;&gt;-->
<!--&lt;!&ndash;      }&ndash;&gt;-->
<!--&lt;!&ndash;      this.pieChart = new Chart(pieChartContext, {&ndash;&gt;-->
<!--&lt;!&ndash;        type: 'pie',&ndash;&gt;-->
<!--&lt;!&ndash;        data: {&ndash;&gt;-->
<!--&lt;!&ndash;          labels: this.merchants.map(merchant => merchant.name),&ndash;&gt;-->
<!--&lt;!&ndash;          datasets: [{&ndash;&gt;-->
<!--&lt;!&ndash;            data: this.chartData.map(data => data.value),&ndash;&gt;-->
<!--&lt;!&ndash;            backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],&ndash;&gt;-->
<!--&lt;!&ndash;            hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],&ndash;&gt;-->
<!--&lt;!&ndash;            hoverBorderColor: '#ffffff'&ndash;&gt;-->
<!--&lt;!&ndash;          }]&ndash;&gt;-->
<!--&lt;!&ndash;        }&ndash;&gt;-->
<!--&lt;!&ndash;      });&ndash;&gt;-->
<!--&lt;!&ndash;    }&ndash;&gt;-->
<!--&lt;!&ndash;  },&ndash;&gt;-->
<!--&lt;!&ndash;  created() {&ndash;&gt;-->
<!--&lt;!&ndash;    // 初始化时展示所有用户并生成图表&ndash;&gt;-->
<!--&lt;!&ndash;    this.filteredUsers = this.users;&ndash;&gt;-->
<!--&lt;!&ndash;    this.updateCharts();&ndash;&gt;-->
<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;};&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;<style scoped>&ndash;&gt;-->
<!--&lt;!&ndash;html, body {&ndash;&gt;-->
<!--&lt;!&ndash;  height: 100%;&ndash;&gt;-->
<!--&lt;!&ndash;  margin: 0;&ndash;&gt;-->
<!--&lt;!&ndash;  font-family: 'Arial', sans-serif;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.merchant-recommendation {&ndash;&gt;-->
<!--&lt;!&ndash;  min-height: 100vh;&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;  background: linear-gradient(135deg, #6a85b6, #bac8e0, #ff79c6);&ndash;&gt;-->
<!--&lt;!&ndash;  color: #333;&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  flex-direction: column;&ndash;&gt;-->
<!--&lt;!&ndash;  align-items: center;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;h2 {&ndash;&gt;-->
<!--&lt;!&ndash;  text-align: center;&ndash;&gt;-->
<!--&lt;!&ndash;  font-size: 2rem;&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 30px;&ndash;&gt;-->
<!--&lt;!&ndash;  color: #ffffff;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.search-container {&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  justify-content: center;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;input {&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 12px 20px;&ndash;&gt;-->
<!--&lt;!&ndash;  width: 100%;&ndash;&gt;-->
<!--&lt;!&ndash;  max-width: 1200px; /* 拉长搜索框 */&ndash;&gt;-->
<!--&lt;!&ndash;  border: 2px solid #ccc;&ndash;&gt;-->
<!--&lt;!&ndash;  border-radius: 8px;&ndash;&gt;-->
<!--&lt;!&ndash;  font-size: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;  transition: border-color 0.3s ease;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;input:focus {&ndash;&gt;-->
<!--&lt;!&ndash;  border-color: #007bff;&ndash;&gt;-->
<!--&lt;!&ndash;  outline: none;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.chart-container {&ndash;&gt;-->
<!--&lt;!&ndash;  width: 80%;&ndash;&gt;-->
<!--&lt;!&ndash;  max-width: 1200px;&ndash;&gt;-->
<!--&lt;!&ndash;  margin: 40px 0;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.merchant-list {&ndash;&gt;-->
<!--&lt;!&ndash;  width: 100%;&ndash;&gt;-->
<!--&lt;!&ndash;  max-width: 1200px;&ndash;&gt;-->
<!--&lt;!&ndash;  display: grid;&ndash;&gt;-->
<!--&lt;!&ndash;  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));&ndash;&gt;-->
<!--&lt;!&ndash;  gap: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;  justify-items: center;  /* 水平居中 */&ndash;&gt;-->
<!--&lt;!&ndash;  align-items: center;    /* 垂直居中 */&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.merchant-item {&ndash;&gt;-->
<!--&lt;!&ndash;  width: 280px;  /* 固定卡片宽度 */&ndash;&gt;-->
<!--&lt;!&ndash;  height: 380px; /* 固定卡片高度 */&ndash;&gt;-->
<!--&lt;!&ndash;  background: #ffffff;&ndash;&gt;-->
<!--&lt;!&ndash;  border-radius: 16px;&ndash;&gt;-->
<!--&lt;!&ndash;  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);&ndash;&gt;-->
<!--&lt;!&ndash;  overflow: hidden;&ndash;&gt;-->
<!--&lt;!&ndash;  transition: transform 0.3s ease, box-shadow 0.3s ease;&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  flex-direction: column;&ndash;&gt;-->
<!--&lt;!&ndash;  justify-content: space-between; /* 让卡片内的内容均匀分布 */&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.merchant-item:hover {&ndash;&gt;-->
<!--&lt;!&ndash;  transform: translateY(-5px);&ndash;&gt;-->
<!--&lt;!&ndash;  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.merchant-content {&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 20px;&ndash;&gt;-->
<!--&lt;!&ndash;  text-align: center;&ndash;&gt;-->
<!--&lt;!&ndash;  display: flex;&ndash;&gt;-->
<!--&lt;!&ndash;  flex-direction: column;&ndash;&gt;-->
<!--&lt;!&ndash;  justify-content: space-between;&ndash;&gt;-->
<!--&lt;!&ndash;  height: 100%; /* 让内容填充整个卡片 */&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.merchant-logo {&ndash;&gt;-->
<!--&lt;!&ndash;  width: 80px;&ndash;&gt;-->
<!--&lt;!&ndash;  height: 80px;&ndash;&gt;-->
<!--&lt;!&ndash;  object-fit: cover;&ndash;&gt;-->
<!--&lt;!&ndash;  border-radius: 50%;&ndash;&gt;-->
<!--&lt;!&ndash;  margin-bottom: 15px;&ndash;&gt;-->
<!--&lt;!&ndash;  transition: transform 0.3s ease;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;.merchant-item:hover .merchant-logo {&ndash;&gt;-->
<!--&lt;!&ndash;  transform: scale(1.1);&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;button {&ndash;&gt;-->
<!--&lt;!&ndash;  background-color: #007bff;&ndash;&gt;-->
<!--&lt;!&ndash;  color: #ffffff;&ndash;&gt;-->
<!--&lt;!&ndash;  border: none;&ndash;&gt;-->
<!--&lt;!&ndash;  padding: 10px 25px;&ndash;&gt;-->
<!--&lt;!&ndash;  border-radius: 30px;&ndash;&gt;-->
<!--&lt;!&ndash;  cursor: pointer;&ndash;&gt;-->
<!--&lt;!&ndash;  font-size: 1rem;&ndash;&gt;-->
<!--&lt;!&ndash;  transition: background-color 0.3s ease, transform 0.2s ease;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;button:hover {&ndash;&gt;-->
<!--&lt;!&ndash;  background-color: #0056b3;&ndash;&gt;-->
<!--&lt;!&ndash;  transform: scale(1.05);&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->

<!--&lt;!&ndash;button:active {&ndash;&gt;-->
<!--&lt;!&ndash;  background-color: #003f7f;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->


<!--<template>-->
<!--  <div class="user-recommendation">-->
<!--    <h2>用户推荐模块</h2>-->
<!--    <h3>推荐的用户</h3>-->

<!--    &lt;!&ndash; 推荐的用户卡片（两行两列布局） &ndash;&gt;-->
<!--    <div class="user-list">-->
<!--      <div v-for="user in filteredUsers.slice(0, 4)" :key="user.id" class="user-item">-->
<!--        <div class="user-content">-->
<!--          <h3>{{ user.name }}</h3>-->
<!--          <p>兴趣分类: {{ user.description }}</p>-->
<!--          <p>评分: {{ user.rating }} / 5</p>-->
<!--          <p>距离: {{ user.distance }} km</p>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "UserRecommendation",-->
<!--  data() {-->
<!--    return {-->
<!--      users: [-->
<!--        { id: 1, name: "用户A", description: "电子产品", rating: 4.5, distance: 2.1 },-->
<!--        { id: 2, name: "用户B", description: "饰品", rating: 4.2, distance: 1.8 },-->
<!--        { id: 3, name: "用户C", description: "服装", rating: 4.8, distance: 0.5 },-->
<!--        { id: 4, name: "用户D", description: "娱乐", rating: 4.0, distance: 3.2 },-->
<!--      ],-->
<!--      filteredUsers: [],-->
<!--    };-->
<!--  },-->
<!--  created() {-->
<!--    // 初始化用户数据-->
<!--    this.filteredUsers = this.users;-->
<!--  },-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--html,-->
<!--body {-->
<!--  margin: 0;-->
<!--  padding: 0;-->
<!--  font-family: "Arial", sans-serif;-->
<!--  background: linear-gradient(135deg, #6a85b6, #bac8e0, #ff79c6);-->
<!--}-->

<!--.user-recommendation {-->
<!--  text-align: center;-->
<!--  padding: 20px;-->
<!--  color: #fff;-->
<!--}-->

<!--h2 {-->
<!--  font-size: 2rem;-->
<!--  margin-bottom: 10px;-->
<!--}-->

<!--h3 {-->
<!--  font-size: 1.5rem;-->
<!--  margin-bottom: 30px;-->
<!--}-->

<!--.user-list {-->
<!--  display: grid;-->
<!--  grid-template-columns: repeat(2, 1fr); /* 两列布局 */-->
<!--  gap: 20px;-->
<!--  justify-content: center;-->
<!--  align-items: center;-->
<!--  max-width: 900px;-->
<!--  margin: 0 auto;-->
<!--}-->

<!--.user-item {-->
<!--  background: #ffffff;-->
<!--  border-radius: 12px;-->
<!--  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);-->
<!--  padding: 20px;-->
<!--  text-align: left;-->
<!--  color: #333;-->
<!--  transition: transform 0.3s ease, box-shadow 0.3s ease;-->
<!--}-->

<!--.user-item:hover {-->
<!--  transform: translateY(-5px);-->
<!--  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);-->
<!--}-->

<!--.user-content h3 {-->
<!--  font-size: 1.3rem;-->
<!--  margin-bottom: 10px;-->
<!--  color: #4e73df;-->
<!--}-->

<!--.user-content p {-->
<!--  font-size: 1rem;-->
<!--  margin: 5px 0;-->
<!--  color: #555;-->
<!--}-->
<!--</style>-->


<!DOCTYPE html>
<html>
<head>
  <title>Merchant Recommendation</title>
  <script>
    async function getRecommendations() {
      const merchantId = document.getElementById("merchant_id").value;

      const response = await fetch('/api/recommend', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ merchant_id: merchantId })
      });

      const result = await response.json();
      document.getElementById("output").innerText = JSON.stringify(result);
    }
  </script>
</head>
<body>
<h1>推荐系统</h1>
<input type="text" id="merchant_id" placeholder="请输入商家ID">
<button onclick="getRecommendations()">获取推荐用户</button>
<pre id="output"></pre>
</body>
</html>
