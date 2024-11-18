<template>
  <div class="container-fluid">
    <div class="row">
      <!-- 左侧导航栏 -->
      <nav id="sidebar" class="col-md-3 col-lg-2 d-md-block sidebar">
        <div class="position-sticky">
          <h4 class="mt-4 text-center">IKUUU VPN</h4>
          <ul class="nav flex-column">
            <li class="nav-item">
              <router-link class="nav-link active" to="/">
                <i class="fas fa-home me-2"></i>首页
              </router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/shop">
                <i class="fas fa-store me-2"></i>商店
              </router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/account">
                <i class="fas fa-user me-2"></i>我的账号
              </router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/lines">
                <i class="fas fa-network-wired me-2"></i>我的线路
              </router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/invite">
                <i class="fas fa-user-friends me-2"></i>邀请注册
              </router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/help">
                <i class="fas fa-question-circle me-2"></i>帮助
              </router-link>
            </li>
          </ul>
        </div>
      </nav>

      <!-- 主内容区域 -->
      <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
        <div class="pt-3 pb-2 mb-3 border-bottom">
          <h2>首页</h2>
        </div>
        <div class="row">
          <div class="col-md-3" v-for="(card, index) in cards" :key="index">
            <div class="card" :class="card.bgClass + ' text-white mb-3'">
              <div class="card-body">
                <h5 class="card-title">{{ card.title }}</h5>
                <p class="card-text">{{ card.content }}</p>
                <small>{{ card.small }}</small>
              </div>
            </div>
          </div>
        </div>

        <!-- 设置时间区域 -->
        <div class="mb-4">
          <h4>设定时间</h4>
          <p>实际世界时间 (UTC+8): {{ realWorldTime }}</p>
          <p>您的系统时间 (UTC+8): {{ systemTime }}</p>
          <p class="text-danger">
            请注意校准上面的两个时间， 相差 10 秒内方可正常使用节点
          </p>
        </div>

        <!-- 公告区域 -->
        <div class="mb-4">
          <h4>公告</h4>
          <p>欢迎使用 iKuuu VPN 最新官网</p>
          <ul>
            <li v-for="(link, index) in announcements" :key="index">
              <a :href="link.url">{{ link.url }}</a>
            </li>
          </ul>
        </div>

        <!-- 流量使用情况 -->
        <div class="mb-4">
          <h4>流量使用情况</h4>
          <div class="chart-container">
            <!-- 可以使用 JavaScript 插入实际的图表 -->
            <p>这里将显示流量的图表。</p>
          </div>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    return {
      cards: [
        {
          title: '会员时长',
          content: '52天',
          small: '专业版: 2025-01-08 过期',
          bgClass: 'bg-primary',
        },
        {
          title: '剩余流量',
          content: '299.35 GB',
          small: '今日用量: 42.61MB',
          bgClass: 'bg-success',
        },
        {
          title: '在线设备数',
          content: '4 / 5',
          small: '上次使用时间: 2024-11-18 19:56:27',
          bgClass: 'bg-info',
        },
        {
          title: '钱包余额',
          content: '&yen;0',
          small: '累计获得返利金额: &yen;0',
          bgClass: 'bg-warning',
        },
      ],
      realWorldTime: '20:30:49',
      systemTime: '20:30:50',
      announcements: [
        { url: 'https://ikuuu.one' },
        { url: 'https://ikuuu.top' },
      ],
    };
  },
};
</script>

<style scoped>
body {
  font-family: 'Arial', sans-serif;
  background-color: #f8f9fa;
}
#sidebar {
  background-color: #343a40;
  min-height: 100vh;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}
#sidebar h4 {
  color: #fff;
  padding: 20px;
  font-weight: bold;
  border-bottom: 1px solid #495057;
}
#sidebar .nav-link {
  color: #adb5bd;
  font-weight: 500;
  padding: 15px;
  transition: background-color 0.3s, color 0.3s;
}
#sidebar .nav-link.active {
  background-color: #495057;
  color: #fff;
}
#sidebar .nav-link:hover {
  background-color: #495057;
  color: #fff;
}
.card {
  border: none;
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
  transition: transform 0.3s;
}
.card:hover {
  transform: translateY(-5px);
}
.card-title {
  font-weight: bold;
}
.chart-container {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  position: relative;
  overflow: hidden;
}
.chart-container::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(135deg, rgba(255, 255, 255, 0.1), rgba(0, 0, 0, 0.1));
  z-index: -1;
}
.mb-4 h4 {
  font-weight: bold;
  color: #343a40;
  border-left: 5px solid #007bff;
  padding-left: 10px;
}
.mb-4 ul li a {
  color: #007bff;
  text-decoration: none;
  transition: color 0.3s;
}
.mb-4 ul li a:hover {
  color: #0056b3;
  text-decoration: underline;
}
.text-danger {
  font-weight: bold;
}
.card-body small {
  font-style: italic;
  color: #f8f9fa;
}
</style>

