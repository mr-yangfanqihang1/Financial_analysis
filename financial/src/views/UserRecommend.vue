<template>
  <div class="user-recommendation">
    <!-- 页面标题 -->
    <h1>用户推荐模块</h1>

    <!-- 原始商家列表 -->
    <div class="original-merchants">
      <h2>所有商家</h2>
      <ul>
        <li v-for="merchant in originalMerchants" :key="merchant.id" class="merchant-card">
          <h3>{{ merchant.name }}</h3>
          <p>分类: {{ merchant.category }}</p>
          <p>ID: {{ merchant.id }}</p>
        </li>
      </ul>
    </div>

    <!-- 推荐结果展示 -->
    <div class="recommendation-list" v-if="relatedValues.length > 0">
      <h2>推荐结果</h2>
      <ul>
        <li v-for="value in relatedValues" :key="value" class="result-item">
          {{ value }}
        </li>
      </ul>
    </div>

    <!-- 用户输入信息 -->
    <div class="user-input">
      <input v-model="userInput" type="text" placeholder="请输入用户ID..." />
      <button @click="handleUserInput" :disabled="isLoading">提交</button>
      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <p v-if="successMessage" class="success">{{ successMessage }}</p>
      <p v-if="isLoading" class="loading">加载中...</p>
    </div>

    <!-- 数据可视化区域（可选） -->
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
import axios from "axios"; // 确保已经安装 axios：npm install axios

export default {
  name: "UserRecommendationModule",
  setup() {
    // 原始推荐商家数据
    const originalMerchants = ref([
      { id: 1, name: "商家A", category: "餐饮", rating: 4.5, distance: 2.1 },
      { id: 2, name: "商家B", category: "服饰", rating: 4.2, distance: 1.8 },
      { id: 3, name: "商家C", category: "超市", rating: 4.8, distance: 0.5 },
      { id: 4, name: "商家D", category: "娱乐", rating: 4.0, distance: 3.2 },
    ]);

    // 推荐结果数据（从后端获取）
    const relatedValues = ref([]);

    // 用户输入的数据
    const userInput = ref("");

    // 错误和成功消息
    const errorMessage = ref("");
    const successMessage = ref("");

    // 加载状态
    const isLoading = ref(false);

    // 处理用户输入的方法
    const handleUserInput = async () => {
      // 重置消息和结果
      errorMessage.value = "";
      successMessage.value = "";
      relatedValues.value = [];

      // 验证用户输入是否为有效的数字
      const inputId = parseInt(userInput.value);
      if (isNaN(inputId) || inputId <= 0) {
        errorMessage.value = "请输入有效的用户 ID（正整数）。";
        return;
      }

      isLoading.value = true;

      try {
        // 调用后端 API 获取推荐结果
        const response = await axios.get(`http://localhost:8080/api/recommendations?userId=${inputId}`);

        if (response.data && response.data.length > 0) {
          relatedValues.value = response.data;
          successMessage.value = `成功找到 ID 为 ${inputId} 的对应值。`;
        } else {
          errorMessage.value = `未找到 ID 为 ${inputId} 的对应值。`;
        }
      } catch (error) {
        console.error(error);
        if (error.response && error.response.status === 404) {
          errorMessage.value = `未找到 ID 为 ${inputId} 的对应值。`;
        } else {
          errorMessage.value = "获取数据时出错，请稍后再试。";
        }
      } finally {
        isLoading.value = false;
      }
    };

    // 图表初始化（保持不变）
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

    return { originalMerchants, relatedValues, userInput, handleUserInput, errorMessage, successMessage, isLoading };
  },
};
</script>

<style scoped>
/* 页面整体布局 */
.user-recommendation {
  padding: 20px;
  background: linear-gradient(135deg, #4facfe, #ff62a5); /* 修改为和主布局 .home 类一样的渐变背景 */
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

/* 原始商家列表样式 */
.original-merchants ul,
.recommendation-list ul {
  list-style: none;
  padding: 0;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.original-merchants ul li,
.recommendation-list ul li {
  background-color: #ffffff;
  margin: 10px;
  padding: 15px;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
  width: 250px;
  text-align: center;
  transition: transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out;
}

.original-merchants ul li:hover,
.recommendation-list ul li:hover {
  transform: translateY(-5px);
  box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
}

.original-merchants ul li h3,
.recommendation-list ul li h3 {
  margin: 10px 0;
  color: #34495e;
}

.original-merchants ul li p,
.recommendation-list ul li p {
  font-size: 0.9rem;
  margin: 5px 0;
  color: #7f8c8d;
}

/* 用户输入信息区域 */
.user-input {
  margin-top: 20px;
  text-align: center;
}

.user-input input {
  padding: 10px;
  width: 300px;
  border-radius: 5px;
  border: 1px solid #ddd;
  margin-right: 10px;
}

.user-input button {
  padding: 10px 20px;
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.user-input button:hover {
  background-color: #2980b9;
}

/* 错误和成功消息样式 */
.error {
  color: red;
  margin-top: 10px;
}

.success {
  color: green;
  margin-top: 10px;
}

.loading {
  color: #f1c40f;
  margin-top: 10px;
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

  .original-merchants ul li,
  .recommendation-list ul li {
    width: 90%;
  }
}
</style>
