<template>
  <div class="info-cards">
    <!-- 欺诈交易识别 -->
    <router-link to="/FraudDetection" class="info-card blue">
      <h2>欺诈交易识别</h2>
      <p>危险</p>
      <small>最新交易: 2024-11-18 19:56:27</small>
    </router-link>

    <!-- 商家推荐模块 -->
    <router-link to="/MchRecommend" class="info-card green">
      <h2>商家推荐模块</h2>
      <p>4 / 5</p>
      <small>上次使用时间: 2024-11-18 19:56:27</small>
    </router-link>

    <!-- 用户推荐模块 -->
    <router-link to="/UserRecommend" class="info-card cyan">
      <h2>用户推荐模块</h2>
      <p>4 / 5</p>
      <small>上次使用时间: 2024-11-18 19:56:27</small>
    </router-link>

    <!-- 用户信誉积分 -->
    <router-link to="/ClientCredit" class="info-card yellow">
      <h2>用户信誉积分</h2>
      <p>90 / 100</p>
      <small>累计充值返利金额 ¥0</small>
    </router-link>

    <!-- 商家数据分析 -->
    <router-link to="/MchAnalysis" class="info-card purple">
      <h2>商家数据分析</h2>
      <p>正常</p>
      <small>最后检查时间: 2024-11-18 21:00:00</small>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "HomeContent",
};
</script>

<style scoped>
.info-cards {
  display: flex;
  justify-content: space-between;
  align-items: stretch;
  flex-wrap: wrap;
}

.info-card {
  flex: 1;
  margin: 10px;
  padding: 10px;
  border-radius: 10px;
  color: white;
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  transition: transform 0.3s ease-in-out;
  text-decoration: none; /* 移除下划线 */
}

.info-card:hover {
  transform: translateY(-10px);
}

.info-card h2 {
  font-size: 1rem;
}

.info-card p {
  font-size: 1.6rem;
  margin: 8px 0;
}

.blue {
  background-color: #5770ed;
}

.cyan {
  background-color: #1abc9c;
}

.green {
  background-color: #2ecc71;
}

.yellow {
  background-color: #f1c40f;
}

.purple {
  background-color: #9b59b6;
}
</style>
