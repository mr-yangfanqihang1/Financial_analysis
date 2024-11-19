<template>
  <div class="home">
    <!-- 左侧灰色侧边栏 -->
    <div class="sidebar">
      <h2>Online Financial Analysis</h2>
      <ul>
        <li><i class="icon-home"></i> 首页</li>
        <li><i class="icon-shop"></i> 商店</li>
        <li><i class="icon-user"></i> 我的账户</li>
        <li><i class="icon-wallet"></i> 我的钱包</li>
        <li><i class="icon-invite"></i> 邀请注册</li>
        <li><i class="icon-help"></i> 帮助</li>
      </ul>
    </div>

    <!-- 右侧内容区域 -->
    <div class="content">
      <div class="info-cards">
        <!-- <div class="info-card blue">
          <h2>欺诈交易识别</h2>
          <p>危险</p>
          <small>专业版: 2025-01-08 过期</small>
        </div> -->
        <router-link to="/FraudDetection" class="info-card cyan">
          <h2>欺诈交易识别</h2>
          <p>4 / 5</p>
          <small>最新交易: 2024-11-18 19:56:27</small>
        </router-link>
        <div class="info-card green">
          <h2>商家推荐模块</h2>
          <p>299.35 GB</p>
          <small>今日使用: 42.61MB</small>
        </router-link>
        <router-link to="/UserRecommend" class="info-card cyan">
          <h2>用户推荐模块</h2>
          <p>4 / 5</p>
          <small>上次使用时间: 2024-11-18 19:56:27</small>
        </router-link>
        <router-link to="/ClientCredit" class="info-card yellow">
          <h2>用户信誉积分</h2>
          <p>90 / 100</p>
          <small>累计充值返利金额 ¥0</small>
        </router-link>
        <div class="info-card purple">
          <h2>系统健康检查</h2>
          <p>正常</p>
          <small>最后检查时间: 2024-11-18 21:00:00</small>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data () {
    return {
      memberDuration: '52天',
      trafficRemaining: '299.35 GB',
      trafficUsedToday: '42.61MB',
      onlineDevices: '4 / 5',
      lastUsed: '2024-11-18 19:56:27',
      walletBalance: '¥0',
      totalRebate: '¥0',
      systemHealthStatus: '正常',
      lastCheckTime: '2024-11-18 21:00:00',
      announcement: [
        { text: 'https://ikuuu.one', link: 'https://ikuuu.one' },
        { text: 'https://ikuuu.top', link: 'https://ikuuu.top' }
      ]
    }
  }
}
</script>

<style scoped>
/* 主布局 */
.home {
  display: flex;
  height: 100vh; /* 限制页面高度为视口高度 */
  overflow: hidden; /* 防止滚动 */
  background: linear-gradient(135deg, #4facfe, #ff62a5); /* 增强渐变效果的对比度 */
}

/* 左侧灰色侧边栏 */
.sidebar {
  width: 20%;
  background-color: #2c3e50;
  color: white;
  padding: 10px 0; /* 上下不留空白 */
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column; /* 垂直排列 */
  position: relative; /* 更改为相对定位，使其随内容滚动 */
  height: auto; /* 高度由内容决定 */
}

/* 左侧侧边栏标题 */
.sidebar h2 {
  font-size: 1rem; /* 缩小字体 */
  margin: 15px 0;
  text-align: center;
}

/* 左侧侧边栏菜单 */
.sidebar ul {
  list-style: none;
  padding: 0;
  flex-grow: 1; /* 占满剩余空间 */
}

.sidebar ul li {
  margin: 10px 0;
  cursor: pointer;
  font-size: 0.8rem; /* 缩小字体 */
  padding: 10px 15px; /* 添加一点内边距 */
}

.sidebar ul li:hover {
  background-color: rgba(255, 255, 255, 0.1); /* 鼠标悬停时增加视觉效果 */
}

/* 右侧内容区域 */
.content {
  width: 80%;
  padding: 10px; /* 减少内边距 */
  margin-left: 1%; /* 右侧内容区域留出左侧边栏的空间 */
  overflow-y: auto; /* 防止超出视口 */
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: auto; /* 高度由内容决定 */
}

/* 信息卡片样式 */
.info-cards {
  display: flex;
  justify-content: space-between;
  align-items: stretch;
  height: auto; /* 确保与左侧侧边栏高度相匹配 */
  flex-wrap: wrap; /* 当卡片数量较多时换行显示 */
}

.info-card {
  flex: 1;
  margin: 10px;
  padding: 10px; /* 调整内边距 */
  border-radius: 10px;
  color: white;
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  transition: transform 0.3s ease-in-out; /* 添加过渡效果 */
}

.info-card:hover {
  transform: translateY(-10px); /* 鼠标悬停时上升 */
}

.info-card h2 {
  font-size: 1rem; /* 缩小标题字体 */
}

.info-card p {
  font-size: 1.6rem; /* 缩小内容字体 */
  margin: 8px 0;
}

/* 卡片颜色样式 */
.blue {
  background-color: #3498db;
}

.green {
  background-color: #2ecc71;
}

.cyan {
  background-color: #1abc9c;
}

.yellow {
  background-color: #f1c40f;
}

.purple {
  background-color: #9b59b6; /* 新增紫色卡片背景色 */
}

/* 时间和公告样式 */
.time-info {
  margin-top: 15px; /* 调整顶部间距 */
}

.time-info .warning {
  color: red;
  font-size: 0.8rem; /* 缩小字体 */
}

.announcement ul {
  padding-left: 20px;
  font-size: 0.8rem; /* 缩小字体 */
}

.traffic-chart {
  margin-top: 15px; /* 调整顶部间距 */
  padding: 10px; /* 调整内边距 */
  background-color: #ecf0f1;
  border-radius: 10px;
  font-size: 0.8rem; /* 缩小字体 */
}
</style>
