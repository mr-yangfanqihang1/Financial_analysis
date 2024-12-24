
<!--<template>-->
<!--  <div class="user-recommendation">-->
<!--    <h2>商家推荐模块</h2>-->

<!--    &lt;!&ndash; 输入商家ID &ndash;&gt;-->
<!--    <div class="merchant-input">-->
<!--      <input-->
<!--          v-model="merchantId"-->
<!--          type="text"-->
<!--          placeholder="请输入商家ID"-->
<!--          class="merchant-id-input"-->
<!--      />-->
<!--      <button @click="fetchRecommendedUsers" class="submit-btn">获取推荐用户</button>-->
<!--    </div>-->

<!--    &lt;!&ndash; 推荐的用户标题 &ndash;&gt;-->
<!--    <h3 v-if="recommendedUsers.length > 0">推荐的用户</h3>-->

<!--    &lt;!&ndash; 推荐的用户卡片（两行两列布局） &ndash;&gt;-->
<!--    <div class="user-list" v-if="recommendedUsers.length > 0">-->
<!--      <div-->
<!--          v-for="user in recommendedUsers.slice(0, 4)"-->
<!--          :key="user.client_id"-->
<!--          class="user-item"-->
<!--      >-->
<!--        <div class="user-content">-->
<!--          <h3>用户ID: {{ user.client_id }}</h3>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->

<!--    &lt;!&ndash; 未加载数据提示 &ndash;&gt;-->
<!--    <p v-if="recommendedUsers.length === 0 && !loading">-->
<!--      暂无推荐用户，请输入商家ID后点击获取推荐用户。-->
<!--    </p>-->
<!--    <p v-if="loading">加载中...</p>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "UserRecommendation",-->
<!--  data() {-->
<!--    return {-->
<!--      merchantId: "", // 用户输入的商家ID-->
<!--      recommendedUsers: [], // 推荐的用户列表-->
<!--      loading: false, // 加载状态-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    async fetchRecommendedUsers() {-->
<!--      // 检查用户是否输入了商家ID-->
<!--      if (!this.merchantId) {-->
<!--        alert("请输入商家ID！");-->
<!--        return;-->
<!--      }-->

<!--      // 设置加载状态-->
<!--      this.loading = true;-->

<!--      try {-->
<!--        // 发送POST请求到后端API-->
<!--        const response = await fetch("http://localhost:8081/api/recommend", {-->
<!--          method: "POST",-->
<!--          headers: {-->
<!--            "Content-Type": "application/json",-->
<!--          },-->
<!--          body: JSON.stringify({ merchant_id: this.merchantId }),-->
<!--        });-->

<!--        // 检查响应状态-->
<!--        if (!response.ok) {-->
<!--          throw new Error("获取推荐用户失败！");-->
<!--        }-->

<!--        // 获取返回的推荐用户数据-->
<!--        const result = await response.json();-->
<!--        this.recommendedUsers = result.recommended_users.map((id) => ({-->
<!--          client_id: id,-->
<!--        }));-->
<!--      } catch (error) {-->
<!--        console.error(error);-->
<!--        alert("获取推荐用户失败，请稍后重试！");-->
<!--      } finally {-->
<!--        // 恢复加载状态-->
<!--        this.loading = false;-->
<!--      }-->
<!--    },-->
<!--  },-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--/* 全局样式 */-->
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

<!--/* 标题样式 */-->
<!--h2 {-->
<!--  font-size: 2rem;-->
<!--  margin-bottom: 10px;-->
<!--}-->

<!--h3 {-->
<!--  font-size: 1.5rem;-->
<!--  margin-bottom: 30px;-->
<!--}-->

<!--/* 商家ID输入框和按钮 */-->
<!--.merchant-input {-->
<!--  margin-bottom: 20px;-->
<!--}-->

<!--.merchant-id-input {-->
<!--  padding: 10px;-->
<!--  border-radius: 8px;-->
<!--  border: 1px solid #ccc;-->
<!--  font-size: 1rem;-->
<!--  width: 250px;-->
<!--  margin-right: 10px;-->
<!--}-->

<!--.submit-btn {-->
<!--  padding: 10px 15px;-->
<!--  border-radius: 8px;-->
<!--  border: none;-->
<!--  background-color: #4e73df;-->
<!--  color: #fff;-->
<!--  font-size: 1rem;-->
<!--  cursor: pointer;-->
<!--  transition: background-color 0.3s ease;-->
<!--}-->

<!--.submit-btn:hover {-->
<!--  background-color: #3759c7;-->
<!--}-->

<!--/* 用户卡片列表 */-->
<!--.user-list {-->
<!--  display: grid;-->
<!--  grid-template-columns: repeat(2, 1fr); /* 两列布局 */-->
<!--  gap: 20px;-->
<!--  justify-content: center;-->
<!--  align-items: center;-->
<!--  max-width: 900px;-->
<!--  margin: 0 auto;-->
<!--}-->

<!--/* 单个用户卡片 */-->
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

<!--/* 卡片内容 */-->
<!--.user-content h3 {-->
<!--  font-size: 1.3rem;-->
<!--  margin-bottom: 10px;-->
<!--  color: #4e73df;-->
<!--}-->
<!--</style>-->

<template>
  <div class="user-recommendation">
    <h2>商家推荐模块</h2>

    <!-- 输入商家ID -->
    <div class="merchant-input">
      <input
          v-model="merchantId"
          type="text"
          placeholder="请输入商家ID"
          class="merchant-id-input"
      />
      <button @click="fetchRecommendedUsers" class="submit-btn">获取推荐用户</button>
    </div>

    <!-- 推荐的用户标题 -->
    <h3 v-if="recommendedUsers.length > 0">推荐的用户</h3>

    <!-- 推荐的用户卡片（两行两列布局） -->
    <div class="user-list" v-if="recommendedUsers.length > 0">
      <div
          v-for="user in recommendedUsers.slice(0, 4)"
          :key="user.client_id"
          class="user-item"
      >
        <div class="user-content">
          <h3>用户ID: {{ user.client_id }}</h3>
          <!-- 显示兴趣度 -->
          <p>兴趣度: {{ user.interest_score.toFixed(2) }}</p>
        </div>
      </div>
    </div>

    <!-- 未加载数据提示 -->
    <p v-if="recommendedUsers.length === 0 && !loading">
      暂无推荐用户，请输入商家ID后点击获取推荐用户。
    </p>
    <p v-if="loading">加载中...</p>
  </div>
</template>

<script>
export default {
  name: "UserRecommendation",
  data() {
    return {
      merchantId: "", // 用户输入的商家ID
      recommendedUsers: [], // 推荐的用户列表
      loading: false, // 加载状态
    };
  },
  methods: {
    async fetchRecommendedUsers() {
      // 检查用户是否输入了商家ID
      if (!this.merchantId) {
        alert("请输入商家ID！");
        return;
      }

      // 设置加载状态
      this.loading = true;

      try {
        // 发送POST请求到后端API
        const response = await fetch("http://localhost:8081/api/recommend", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ merchant_id: this.merchantId }),
        });

        // 检查响应状态
        if (!response.ok) {
          throw new Error("获取推荐用户失败！");
        }

        // 获取返回的推荐用户数据
        const result = await response.json();

        // 假设后端返回的数据结构如下：
        // { recommended_users: [{ client_id: 12345, interest_score: 0.876 }, ...] }
        this.recommendedUsers = result.recommended_users.map((user) => ({
          client_id: user.client_id,
          interest_score: user.interest_score, // 确保包含兴趣度
        }));
      } catch (error) {
        console.error(error);
        alert("获取推荐用户失败，请稍后重试！");
      } finally {
        // 恢复加载状态
        this.loading = false;
      }
    },
  },
};
</script>

<style scoped>
/* 全局样式 */
html,
body {
  margin: 0;
  padding: 0;
  font-family: "Arial", sans-serif;
  background: linear-gradient(135deg, #6a85b6, #bac8e0, #ff79c6);
}

.user-recommendation {
  text-align: center;
  padding: 20px;
  color: #fff;
}

/* 标题样式 */
h2 {
  font-size: 2rem;
  margin-bottom: 10px;
}

h3 {
  font-size: 1.5rem;
  margin-bottom: 30px;
}

/* 商家ID输入框和按钮 */
.merchant-input {
  margin-bottom: 20px;
}

.merchant-id-input {
  padding: 10px;
  border-radius: 8px;
  border: 1px solid #ccc;
  font-size: 1rem;
  width: 250px;
  margin-right: 10px;
}

.submit-btn {
  padding: 10px 15px;
  border-radius: 8px;
  border: none;
  background-color: #4e73df;
  color: #fff;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-btn:hover {
  background-color: #3759c7;
}

/* 用户卡片列表 */
.user-list {
  display: grid;
  grid-template-columns: repeat(2, 1fr); /* 两列布局 */
  gap: 20px;
  justify-content: center;
  align-items: center;
  max-width: 900px;
  margin: 0 auto;
}

/* 单个用户卡片 */
.user-item {
  background: #ffffff;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
  padding: 20px;
  text-align: left;
  color: #333;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.user-item:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
}

/* 卡片内容 */
.user-content h3 {
  font-size: 1.3rem;
  margin-bottom: 10px;
  color: #4e73df;
}

.user-content p {
  font-size: 1.1rem;
  color: #666;
}
</style>
