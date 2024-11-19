<template>
  <div class="user-recommendation">
    <!-- 页面标题 -->
    <h1>用户推荐模块</h1>

    <!-- 推荐商家列表 -->
    <div class="recommendation-list">
      <h2>推荐的商家</h2>
      <ul>
        <li v-for="merchant in recommendedMerchants" :key="merchant.id">
          <h3>{{ merchant.name }}</h3>
          <p>分类: {{ merchant.category }}</p>
          <p>评分: {{ merchant.rating }} / 5</p>
          <p>距离: {{ merchant.distance }} km</p>
        </li>
      </ul>
    </div>

    <!-- 数据可视化区域 -->
    <div class="charts">
      <h2>推荐数据可视化</h2>
      <!-- 扇形图 -->
      <div class="chart-container">
        <h3>推荐商家分类分布</h3>
        <canvas id="categoryPieChart"></canvas>
      </div>

      <!-- 条状图 -->
      <div class="chart-container">
        <h3>用户与商家互动数据</h3>
        <canvas id="interactionBarChart"></canvas>
      </div>
    </div>
  </div>
</template>

<script>
import { onMounted, ref } from "vue";
import Chart from "chart.js/auto";

export default {
  name: "UserRecommendationModule",
  setup() {
    // 推荐商家数据
    const recommendedMerchants = ref([
      { id: 1, name: "商家A", category: "餐饮", rating: 4.5, distance: 2.1 },
      { id: 2, name: "商家B", category: "服饰", rating: 4.2, distance: 1.8 },
      { id: 3, name: "商家C", category: "超市", rating: 4.8, distance: 0.5 },
      { id: 4, name: "商家D", category: "娱乐", rating: 4.0, distance: 3.2 },
    ]);

    // 图表初始化
    onMounted(() => {
      // 扇形图 - 商家分类分布
      new Chart(document.getElementById("categoryPieChart"), {
        type: "pie",
        data: {
          labels: ["餐饮", "服饰", "超市", "娱乐"],
          datasets: [
            {
              label: "商家分类分布",
              data: [40, 25, 20, 15],
              backgroundColor: ["#3498db", "#2ecc71", "#f1c40f", "#e74c3c"],
            },
          ],
        },
        options: {
          responsive: true,
        },
      });

      // 条状图 - 用户与商家互动数据
      new Chart(document.getElementById("interactionBarChart"), {
        type: "bar",
        data: {
          labels: ["商家A", "商家B", "商家C", "商家D"],
          datasets: [
            {
              label: "点击量",
              data: [50, 30, 70, 40],
              backgroundColor: "#2ecc71",
            },
            {
              label: "收藏量",
              data: [20, 15, 35, 25],
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

    return { recommendedMerchants };
  },
};
</script>

<style scoped>
.user-recommendation {
  padding: 20px;
  background-color: #f7f9fb;
  color: #333;
  font-family: Arial, sans-serif;
}

h1,
h2 {
  text-align: center;
  margin-bottom: 20px;
}

.recommendation-list ul {
  list-style: none;
  padding: 0;
}

.recommendation-list ul li {
  background-color: #ffffff;
  margin: 10px 0;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.charts {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  margin-top: 20px;
}

.chart-container {
  width: 45%;
  margin-bottom: 20px;
  background-color: #fff;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}
</style>
