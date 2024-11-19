<template>
  <div class="user-recommendation">
    <!-- 页面标题 -->
    <h1>用户推荐模块</h1>

    <!-- 推荐商家列表 -->
    <div class="recommendation-list">
      <h2>推荐的商家</h2>
      <ul>
        <li v-for="merchant in recommendedMerchants" :key="merchant.id" class="merchant-card">
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
      <div class="charts-container">
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
/* 页面整体布局 */
.user-recommendation {
  padding: 20px;
  background: linear-gradient(135deg, #d3e0ff, #b2dffb, #fef6e4); /* 修改为柔和渐变色，保持主色调一致 */
  color: #333;
  font-family: Arial, sans-serif;
}

/* 标题样式 */
h1,
h2 {
  text-align: center;
  margin-bottom: 20px;
  font-weight: bold;
  color: #2c3e50;
}

/* 推荐商家列表样式 */
.recommendation-list ul {
  list-style: none;
  padding: 0;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.merchant-card {
  background-color: #ffffff;
  margin: 10px;
  padding: 15px;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
  width: 250px;
  text-align: center;
  transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
}

.merchant-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
}

.merchant-card h3 {
  margin: 10px 0;
  color: #34495e;
}

.merchant-card p {
  font-size: 0.9rem;
  margin: 5px 0;
  color: #7f8c8d;
}

/* 数据可视化区域 */
.charts {
  margin-top: 30px;
}

/* 包含图表的容器，水平排列图表 */
.charts-container {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}

/* 单个图表容器样式 */
.chart-container {
  width: 45%;
  margin-bottom: 20px;
  background: #ffffff;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
}

.chart-container h3 {
  text-align: center;
  margin-bottom: 10px;
  color: #34495e;
}

/* 响应式设计 */
@media screen and (max-width: 768px) {
  .charts-container {
    flex-direction: column;
    align-items: center;
  }

  .chart-container {
    width: 90%;
  }

  .merchant-card {
    width: 90%;
  }
}
</style>
