<template>
  <main class="main-content">
    <h1>流失用户预测</h1>

    <!-- 预测按钮 -->
    <div class="button-container">
      <button @click="getData" class="predict-button">预测</button>
    </div>

    <!-- 整体统计分析 -->
    <section class="overall-analysis">
      <div class="info-cards">
        <!-- 使用 v-for 循环生成卡片 -->
        <div
          v-for="(user, index) in users"
          :key="index"
          class="info-card"
          :class="getCardColor(index)"
        >
          <h2>{{ user.id }}</h2>
          <p>流失概率: {{ user.probability }}</p>
        </div>
      </div>
    </section>
  </main>
</template>

<script>
import api from "../api/api.js";
export default {
  name: "MchAnalysis",
  data() {
    return {
      // 定义用户数据
      users: [
        { id: "用户ID1", probability: "P(1)" },
        { id: "用户ID2", probability: "P(2)" },
        { id: "用户ID3", probability: "P(3)" },
        { id: "用户ID4", probability: "P(4)" },
        { id: "用户ID5", probability: "P(5)" },
        { id: "用户ID6", probability: "P(6)" },
      ],
    };
  },
  methods: {
    // 根据索引返回不同的背景色，交替颜色
    getCardColor(index) {
      return index % 2 === 0 ? "cyan" : "yellow";
    },

    async getData() {
      try {
        const response = await api.getChurnData();
        this.users = response.data.data;
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    },
  },
  async created() {
    await this.getData();
  },
};
</script>

<style scoped>
.main-content {
  background: #f6faff; /* 白色背景 */
  padding: 20px;
  min-height: 100vh; /* 确保背景至少覆盖整个屏幕 */
  box-sizing: border-box; /* 包括内边距在内计算高度 */
  display: flex; /* 可能有其他元素影响布局，确保父容器采用 flex 布局 */
  flex-direction: column;
}

.button-container {
  margin-bottom: 20px; /* 按钮与内容之间的间距 */
  text-align: center;
}

.predict-button {
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}

.predict-button:hover {
  background-color: #2980b9;
}

.info-cards {
  display: flex;
  flex-wrap: wrap; /* 允许换行 */
  justify-content: space-between; /* 每行卡片间距 */
  gap: 10px; /* 增加卡片之间的间距 */
}

.info-card {
  flex: 0 1 25%; /* 每个卡片占据25%的宽度，剩余空间自适应 */
  margin: 10px;
  padding: 20px;
  border-radius: 10px;
  color: white;
  text-align: center;
}
.cyan {
  background-color: #1abc9c;
}

.yellow {
  background-color: #f1c40f;
}
</style>
