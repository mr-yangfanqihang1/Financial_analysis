<template>
  <div class="layout">
    <!-- 左边灰色区域 -->
    <div class="sidebar">
      <h2>侧边栏</h2>
      <ul>
        <li>菜单项 1</li>
        <li>菜单项 2</li>
        <li>菜单项 3</li>
        <li>菜单项 4</li>
      </ul>
    </div>
    <!-- 右边白色内容区域 -->
    <div class="content">
      <h1>内容区域</h1>
      <p>这是内容区域，可以根据需要添加内容。</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LayoutView'
}
</script>

<style scoped>
/* 设置整体布局 */
.layout {
  display: flex;
  height: 100vh;
  margin: 0;
}

/* 左边灰色区域样式 */
.sidebar {
  width: 20%;
  background-color: #2c3e50; /* 深灰色 */
  color: white;
  padding: 20px;
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
}

.sidebar h2 {
  font-size: 1.5rem;
  margin-bottom: 20px;
}

.sidebar ul {
  list-style: none;
  padding: 0;
}

.sidebar ul li {
  margin: 10px 0;
  cursor: pointer;
}

/* 右边白色区域样式 */
.content {
  width: 80%;
  background-color: white;
  padding: 20px;
}
</style>
