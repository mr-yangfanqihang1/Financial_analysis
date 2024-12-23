<template>
  <div class="home">
    <!-- 左侧灰色侧边栏 -->
    <div class="sidebar">
      <h2>Online Financial Analysis</h2>
      <ul>
        <router-link tag="li" to="/" exact>
          <i class="icon-home"></i> 首页
        </router-link>
        <router-link tag="li" to="/FraudDetection">
          <i class="icon-fraud"></i> 欺诈交易识别
        </router-link>
        <router-link tag="li" to="/MchRecommend">
          <i class="icon-merchant"></i> 商家推荐模块
        </router-link>
        <router-link tag="li" to="/UserRecommend">
          <i class="icon-user-recommend"></i> 用户推荐模块
        </router-link>
        <router-link tag="li" to="/ClientCredit">
          <i class="icon-credit"></i> 用户信誉积分
        </router-link>
        <router-link tag="li" to="/MchAnalysis">
          <i class="icon-health"></i> 商家数据分析
        </router-link>
      </ul>
    </div>

    <!-- 右侧内容区域 -->
    <div class="content">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeView",
};
</script>

<style scoped>
/* 主布局 */
.home {
  display: flex;
  height: 100vh; /* 限制页面高度为视口高度 */
  background: linear-gradient(135deg, #4facfe, #ff62a5); /* 渐变背景 */
}

/* 左侧灰色侧边栏 */
.sidebar {
  width: 20%;
  background-color: #2c3e50;
  color: white;
  padding: 20px;
}

.sidebar h2 {
  text-align: center;
  margin-bottom: 20px;
}

.sidebar ul {
  list-style: none;
  padding: 0;
}

.sidebar ul li {
  margin: 10px 0;
  cursor: pointer;
  padding: 10px;
  border-radius: 5px;
}

/* 移除 router-link 默认的下划线 */
.sidebar ul li a {
  text-decoration: none; /* 移除链接的下划线 */
  color: inherit; /* 保持链接文字颜色与父级一致 */
  display: flex; /* 使链接中的图标和文字在同一行显示 */
  align-items: center; /* 垂直居中对齐 */
}

.sidebar ul li:hover {
  background-color: rgba(255, 255, 255, 0.1);
}

.sidebar ul li.active {
  background-color: #1abc9c;
}

/* 右侧内容区域 */
.content {
  flex: 1;
  padding: 20px;
  overflow-y: auto;
}
</style>
