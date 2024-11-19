<!--<template>-->
<!--  <div class="merchant-recommendation">-->
<!--    <h2>商家推荐</h2>-->
<!--    <div class="merchant-cards">-->
<!--      <div v-for="merchant in merchants" :key="merchant.id" class="merchant-card">-->
<!--        <div class="merchant-card-content">-->
<!--          <img :src="merchant.image" alt="Merchant Image" class="merchant-image" />-->
<!--          <h3>{{ merchant.name }}</h3>-->
<!--          <p>{{ merchant.description }}</p>-->
<!--          <button @click="goToMerchant(merchant.link)">查看详情</button>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: 'MerchantRecommendation',-->
<!--  data() {-->
<!--    return {-->
<!--      merchants: [-->
<!--        {-->
<!--          id: 1,-->
<!--          name: '商家A',-->
<!--          description: '高质量产品，优质服务',-->
<!--          image: 'https://example.com/merchant-a.jpg',-->
<!--          link: 'https://example.com/merchant-a'-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          name: '商家B',-->
<!--          description: '经济实惠，值得信赖',-->
<!--          image: 'https://example.com/merchant-b.jpg',-->
<!--          link: 'https://example.com/merchant-b'-->
<!--        },-->
<!--        // 其他商家信息-->
<!--      ]-->
<!--    };-->
<!--  },-->
<!--  methods: {-->
<!--    goToMerchant(link) {-->
<!--      window.location.href = link;-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.merchant-recommendation {-->
<!--  padding: 20px;-->
<!--}-->

<!--.merchant-cards {-->
<!--  display: flex;-->
<!--  gap: 20px;-->
<!--  flex-wrap: wrap;-->
<!--}-->

<!--.merchant-card {-->
<!--  background: #fff;-->
<!--  border-radius: 8px;-->
<!--  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);-->
<!--  padding: 16px;-->
<!--  width: 200px;-->
<!--  text-align: center;-->
<!--  transition: transform 0.3s;-->
<!--}-->

<!--.merchant-card:hover {-->
<!--  transform: translateY(-5px);-->
<!--}-->

<!--.merchant-image {-->
<!--  width: 100%;-->
<!--  height: 120px;-->
<!--  object-fit: cover;-->
<!--  border-radius: 8px;-->
<!--  margin-bottom: 12px;-->
<!--}-->

<!--button {-->
<!--  background-color: #007bff;-->
<!--  color: white;-->
<!--  border: none;-->
<!--  padding: 8px 16px;-->
<!--  border-radius: 4px;-->
<!--  cursor: pointer;-->
<!--}-->

<!--button:hover {-->
<!--  background-color: #0056b3;-->
<!--}-->
<!--</style>-->




<!------------------------------------------------------------------------------------------------------------------------------>




<!--<template>-->
<!--  <div class="merchant-recommendation">-->
<!--    <h2>推荐商家</h2>-->
<!--    <div class="merchant-list">-->
<!--      <div v-for="merchant in merchants" :key="merchant.id" class="merchant-item">-->
<!--        <img :src="merchant.logo" :alt="`${merchant.name} logo`" class="merchant-logo" />-->
<!--        <div class="merchant-info">-->
<!--          <h3>{{ merchant.name }}</h3>-->
<!--          <p>{{ merchant.description }}</p>-->
<!--          <button @click="visitMerchant(merchant.link)">了解更多</button>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: 'MerchantRecommendation',-->
<!--  data () {-->
<!--    return {-->
<!--      merchants: [-->
<!--        {-->
<!--          id: 1,-->
<!--          name: '商家甲',-->
<!--          description: '优质产品和服务，深受客户好评。',-->
<!--          logo: 'https://example.com/merchant-logo-a.jpg',-->
<!--          link: 'https://example.com/merchant-a'-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          name: '商家乙',-->
<!--          description: '提供实惠的产品，性价比高。',-->
<!--          logo: 'https://example.com/merchant-logo-b.jpg',-->
<!--          link: 'https://example.com/merchant-b'-->
<!--        },-->
<!--        {-->
<!--          id: 3,-->
<!--          name: '商家丙',-->
<!--          description: '新兴品牌，创新理念。',-->
<!--          logo: 'https://example.com/merchant-logo-c.jpg',-->
<!--          link: 'https://example.com/merchant-c'-->
<!--        }-->
<!--      ]-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    visitMerchant (link) {-->
<!--      window.open(link, '_blank')-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--.merchant-recommendation {-->
<!--  padding: 20px;-->
<!--  background-color: #f9f9f9;-->
<!--}-->

<!--.merchant-list {-->
<!--  display: grid;-->
<!--  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));-->
<!--  gap: 20px;-->
<!--}-->

<!--.merchant-item {-->
<!--  background: #ffffff;-->
<!--  border-radius: 8px;-->
<!--  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);-->
<!--  overflow: hidden;-->
<!--  transition: box-shadow 0.3s ease;-->
<!--}-->

<!--.merchant-item:hover {-->
<!--  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);-->
<!--}-->

<!--.merchant-logo {-->
<!--  width: 100%;-->
<!--  height: 150px;-->
<!--  object-fit: cover;-->
<!--}-->

<!--.merchant-info {-->
<!--  padding: 15px;-->
<!--  text-align: center;-->
<!--}-->

<!--.merchant-info h3 {-->
<!--  margin-bottom: 10px;-->
<!--  font-size: 1.2em;-->
<!--  color: #333;-->
<!--}-->

<!--.merchant-info p {-->
<!--  font-size: 0.95em;-->
<!--  color: #666;-->
<!--  margin-bottom: 15px;-->
<!--}-->

<!--button {-->
<!--  background-color: #007bff;-->
<!--  color: #ffffff;-->
<!--  border: none;-->
<!--  padding: 10px 20px;-->
<!--  border-radius: 4px;-->
<!--  cursor: pointer;-->
<!--  transition: background-color 0.3s ease;-->
<!--}-->

<!--/* 右边白色区域样式 */-->
<!--.content {-->
<!--  width: 80%;-->
<!--  background-color: white;-->
<!--  padding: 20px;-->
<!--}-->
<!--</style>-->




<!-------------------------------------------------------------------------------------------------------------------------------->

<!--<template>-->
<!--  <div class="merchant-recommendation">-->
<!--    <h2>推荐商家</h2>-->

<!--    &lt;!&ndash; 搜索框 &ndash;&gt;-->
<!--    <div class="search-container">-->
<!--      <input-->
<!--          type="text"-->
<!--          v-model="searchQuery"-->
<!--          placeholder="请输入用户ID搜索感兴趣的商户"-->
<!--          @input="filterMerchants"-->
<!--      />-->
<!--    </div>-->

<!--    <div class="merchant-list">-->
<!--      <div v-for="merchant in filteredMerchants" :key="merchant.id" class="merchant-item">-->
<!--        <img :src="merchant.logo" :alt="`${merchant.name} logo`" class="merchant-logo" />-->
<!--        <div class="merchant-info">-->
<!--          <h3>{{ merchant.name }}</h3>-->
<!--          <p>{{ merchant.description }}</p>-->
<!--          <button @click="visitMerchant(merchant.link)">了解更多</button>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: 'MerchantRecommendation',-->
<!--  data () {-->
<!--    return {-->
<!--      searchQuery: '', // 用户输入的搜索ID-->
<!--      merchants: [-->
<!--        {-->
<!--          id: 1,-->
<!--          name: '商家甲',-->
<!--          description: '优质产品和服务，深受客户好评。',-->
<!--          logo: 'https://example.com/merchant-logo-a.jpg',-->
<!--          link: 'https://example.com/merchant-a'-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          name: '商家乙',-->
<!--          description: '提供实惠的产品，性价比高。',-->
<!--          logo: 'https://example.com/merchant-logo-b.jpg',-->
<!--          link: 'https://example.com/merchant-b'-->
<!--        },-->
<!--        {-->
<!--          id: 3,-->
<!--          name: '商家丙',-->
<!--          description: '新兴品牌，创新理念。',-->
<!--          logo: 'https://example.com/merchant-logo-c.jpg',-->
<!--          link: 'https://example.com/merchant-c'-->
<!--        }-->
<!--      ],-->
<!--      filteredMerchants: [] // 用于存储筛选后的商户列表-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    visitMerchant (link) {-->
<!--      window.open(link, '_blank')-->
<!--    },-->
<!--    filterMerchants() {-->
<!--      if (this.searchQuery === '') {-->
<!--        // 如果没有输入ID，则显示所有商户-->
<!--        this.filteredMerchants = this.merchants;-->
<!--      } else {-->
<!--        // 根据用户输入的ID筛选商户-->
<!--        const userId = parseInt(this.searchQuery, 10);-->
<!--        this.filteredMerchants = this.merchants.filter(merchant => merchant.id === userId);-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  created() {-->
<!--    // 初始化时展示所有商户-->
<!--    this.filteredMerchants = this.merchants;-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--.merchant-recommendation {-->
<!--  padding: 20px;-->
<!--  background-color: #f9f9f9;-->
<!--}-->

<!--.search-container {-->
<!--  margin-bottom: 20px;-->
<!--}-->

<!--input {-->
<!--  padding: 8px;-->
<!--  width: 100%;-->
<!--  max-width: 300px;-->
<!--  border: 1px solid #ddd;-->
<!--  border-radius: 4px;-->
<!--  font-size: 1rem;-->
<!--}-->

<!--.merchant-list {-->
<!--  display: grid;-->
<!--  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));-->
<!--  gap: 20px;-->
<!--}-->

<!--.merchant-item {-->
<!--  background: #ffffff;-->
<!--  border-radius: 8px;-->
<!--  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);-->
<!--  overflow: hidden;-->
<!--  transition: box-shadow 0.3s ease;-->
<!--}-->

<!--.merchant-item:hover {-->
<!--  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);-->
<!--}-->

<!--.merchant-logo {-->
<!--  width: 100%;-->
<!--  height: 150px;-->
<!--  object-fit: cover;-->
<!--}-->

<!--.merchant-info {-->
<!--  padding: 15px;-->
<!--  text-align: center;-->
<!--}-->

<!--.merchant-info h3 {-->
<!--  margin-bottom: 10px;-->
<!--  font-size: 1.2em;-->
<!--  color: #333;-->
<!--}-->

<!--.merchant-info p {-->
<!--  font-size: 0.95em;-->
<!--  color: #666;-->
<!--  margin-bottom: 15px;-->
<!--}-->

<!--button {-->
<!--  background-color: #007bff;-->
<!--  color: #ffffff;-->
<!--  border: none;-->
<!--  padding: 10px 20px;-->
<!--  border-radius: 4px;-->
<!--  cursor: pointer;-->
<!--  transition: background-color 0.3s ease;-->
<!--}-->
<!--</style>-->




<!-------------------------------------------------------------------------------------------------------------------------------->

<!--<template>-->
<!--  <div class="merchant-recommendation">-->
<!--    <h2>推荐商家</h2>-->

<!--    &lt;!&ndash; 搜索框 &ndash;&gt;-->
<!--    <div class="search-container">-->
<!--      <input-->
<!--          type="text"-->
<!--          v-model="searchQuery"-->
<!--          placeholder="请输入用户ID搜索感兴趣的商户"-->
<!--          @input="filterMerchants"-->
<!--      />-->
<!--    </div>-->

<!--    <div class="merchant-list">-->
<!--      <div v-for="merchant in filteredMerchants" :key="merchant.id" class="merchant-item">-->
<!--        <img :src="merchant.logo" :alt="`${merchant.name} logo`" class="merchant-logo" />-->
<!--        <div class="merchant-info">-->
<!--          <h3>{{ merchant.name }}</h3>-->
<!--          <p>{{ merchant.description }}</p>-->
<!--          <button @click="visitMerchant(merchant.link)">了解更多</button>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: 'MerchantRecommendation',-->
<!--  data () {-->
<!--    return {-->
<!--      searchQuery: '', // 用户输入的搜索ID-->
<!--      merchants: [-->
<!--        {-->
<!--          id: 1,-->
<!--          name: '商家甲',-->
<!--          description: '优质产品和服务，深受客户好评。',-->
<!--          logo: 'https://example.com/merchant-logo-a.jpg',-->
<!--          link: 'https://example.com/merchant-a'-->
<!--        },-->
<!--        {-->
<!--          id: 2,-->
<!--          name: '商家乙',-->
<!--          description: '提供实惠的产品，性价比高。',-->
<!--          logo: 'https://example.com/merchant-logo-b.jpg',-->
<!--          link: 'https://example.com/merchant-b'-->
<!--        },-->
<!--        {-->
<!--          id: 3,-->
<!--          name: '商家丙',-->
<!--          description: '新兴品牌，创新理念。',-->
<!--          logo: 'https://example.com/merchant-logo-c.jpg',-->
<!--          link: 'https://example.com/merchant-c'-->
<!--        }-->
<!--      ],-->
<!--      filteredMerchants: [] // 用于存储筛选后的商户列表-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    visitMerchant (link) {-->
<!--      window.open(link, '_blank')-->
<!--    },-->
<!--    filterMerchants() {-->
<!--      if (this.searchQuery === '') {-->
<!--        // 如果没有输入ID，则显示所有商户-->
<!--        this.filteredMerchants = this.merchants;-->
<!--      } else {-->
<!--        // 根据用户输入的ID筛选商户-->
<!--        const userId = parseInt(this.searchQuery, 10);-->
<!--        this.filteredMerchants = this.merchants.filter(merchant => merchant.id === userId);-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  created() {-->
<!--    // 初始化时展示所有商户-->
<!--    this.filteredMerchants = this.merchants;-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<style scoped>-->
<!--html, body {-->
<!--  height: 100%;-->
<!--  margin: 0;-->
<!--  font-family: 'Arial', sans-serif;-->
<!--}-->

<!--.merchant-recommendation {-->
<!--  min-height: 100vh; /* 确保背景覆盖整个视窗 */-->
<!--  padding: 20px;-->
<!--  background: linear-gradient(135deg, #6a85b6, #bac8e0, #ff79c6);-->
<!--  color: #333;-->
<!--  display: flex;-->
<!--  flex-direction: column;-->
<!--  align-items: center;-->
<!--}-->

<!--h2 {-->
<!--  text-align: center;-->
<!--  font-size: 1.8rem;-->
<!--  margin-bottom: 30px;-->
<!--  color: #ffffff;-->
<!--}-->

<!--.search-container {-->
<!--  margin-bottom: 20px;-->
<!--  display: flex;-->
<!--  justify-content: center;-->
<!--}-->

<!--input {-->
<!--  padding: 12px 20px;-->
<!--  width: 100%;-->
<!--  max-width: 400px;-->
<!--  border: 2px solid #ccc;-->
<!--  border-radius: 8px;-->
<!--  font-size: 1rem;-->
<!--  transition: border-color 0.3s ease;-->
<!--}-->

<!--input:focus {-->
<!--  border-color: #007bff;-->
<!--  outline: none;-->
<!--}-->

<!--.merchant-list {-->
<!--  width: 100%;-->
<!--  max-width: 1200px;-->
<!--  display: grid;-->
<!--  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));-->
<!--  gap: 30px;-->
<!--}-->

<!--.merchant-item {-->
<!--  background: #ffffff;-->
<!--  border-radius: 12px;-->
<!--  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);-->
<!--  overflow: hidden;-->
<!--  transition: transform 0.3s ease, box-shadow 0.3s ease;-->
<!--}-->

<!--.merchant-item:hover {-->
<!--  transform: translateY(-5px);-->
<!--  box-shadow: 0 6px 20px rgba(0, 0, 0, 0.2);-->
<!--}-->

<!--.merchant-logo {-->
<!--  width: 100%;-->
<!--  height: 200px;-->
<!--  object-fit: cover;-->
<!--  border-bottom: 2px solid #f4f7fc;-->
<!--}-->

<!--.merchant-info {-->
<!--  padding: 20px;-->
<!--  text-align: center;-->
<!--  background: linear-gradient(135deg, #90caf9, #4db6ac);-->
<!--}-->

<!--.merchant-info h3 {-->
<!--  font-size: 1.3em;-->
<!--  margin-bottom: 10px;-->
<!--  color: #333;-->
<!--  font-weight: 600;-->
<!--}-->

<!--.merchant-info p {-->
<!--  font-size: 1em;-->
<!--  color: #666;-->
<!--  margin-bottom: 15px;-->
<!--}-->

<!--button {-->
<!--  background-color: #ffca28;-->
<!--  color: #ffffff;-->
<!--  border: none;-->
<!--  padding: 12px 24px;-->
<!--  border-radius: 6px;-->
<!--  cursor: pointer;-->
<!--  font-size: 1rem;-->
<!--  transition: background-color 0.3s ease, transform 0.2s ease;-->
<!--}-->

<!--button:hover {-->
<!--  background-color: #ffb300;-->
<!--  transform: scale(1.05);-->
<!--}-->

<!--button:active {-->
<!--  background-color: #ffa000;-->
<!--}-->
<!--</style>-->



<!----------------------------------------------------------------------------------------------------------------------------->

<template>
  <div class="merchant-recommendation">
    <h2>推荐商家</h2>

    <!-- 搜索框 -->
    <div class="search-container">
      <input
          type="text"
          v-model="searchQuery"
          placeholder="请输入用户ID搜索感兴趣的商户"
          @input="filterMerchants"
      />
    </div>

    <div class="merchant-list">
      <div v-for="merchant in filteredMerchants" :key="merchant.id" class="merchant-item">
        <div class="merchant-content">
          <img :src="merchant.logo" :alt="`${merchant.name} logo`" class="merchant-logo" />
          <h3>{{ merchant.name }}</h3>
          <p>{{ merchant.description }}</p>
          <button @click="visitMerchant(merchant.link)">了解更多</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MerchantRecommendation',
  data () {
    return {
      searchQuery: '', // 用户输入的搜索ID
      merchants: [
        {
          id: 1,
          name: '商家甲',
          description: '优质产品和服务，深受客户好评。',
          logo: 'https://example.com/merchant-logo-a.jpg',
          link: 'https://example.com/merchant-a'
        },
        {
          id: 2,
          name: '商家乙',
          description: '提供实惠的产品，性价比高。',
          logo: 'https://example.com/merchant-logo-b.jpg',
          link: 'https://example.com/merchant-b'
        },
        {
          id: 3,
          name: '商家丙',
          description: '新兴品牌，创新理念。',
          logo: 'https://example.com/merchant-logo-c.jpg',
          link: 'https://example.com/merchant-c'
        }
      ],
      filteredMerchants: [] // 用于存储筛选后的商户列表
    }
  },
  methods: {
    visitMerchant (link) {
      window.open(link, '_blank')
    },
    filterMerchants() {
      if (this.searchQuery === '') {
        // 如果没有输入ID，则显示所有商户
        this.filteredMerchants = this.merchants;
      } else {
        // 根据用户输入的ID筛选商户
        const userId = parseInt(this.searchQuery, 10);
        this.filteredMerchants = this.merchants.filter(merchant => merchant.id === userId);
      }
    }
  },
  created() {
    // 初始化时展示所有商户
    this.filteredMerchants = this.merchants;
  }
}
</script>

<style scoped>
html, body {
  height: 100%;
  margin: 0;
  font-family: 'Arial', sans-serif;
}

.merchant-recommendation {
  min-height: 100vh;
  padding: 20px;
  background: linear-gradient(135deg, #6a85b6, #bac8e0, #ff79c6);
  color: #333;
  display: flex;
  flex-direction: column;
  align-items: center;
}

h2 {
  text-align: center;
  font-size: 2rem;
  margin-bottom: 30px;
  color: #ffffff;
}

.search-container {
  margin-bottom: 20px;
  display: flex;
  justify-content: center;
}

input {
  padding: 12px 20px;
  width: 100%;
  max-width: 1200px; /* 拉长搜索框 */
  border: 2px solid #ccc;
  border-radius: 8px;
  font-size: 1rem;
  transition: border-color 0.3s ease;
}

input:focus {
  border-color: #007bff;
  outline: none;
}

.merchant-list {
  width: 100%;
  max-width: 1200px;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 20px;
  justify-items: center;  /* 水平居中 */
  align-items: center;    /* 垂直居中 */
}

.merchant-item {
  width: 280px;  /* 固定卡片宽度 */
  height: 380px; /* 固定卡片高度 */
  background: #ffffff;
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  display: flex;
  flex-direction: column;
  justify-content: space-between; /* 让卡片内的内容均匀分布 */
}

.merchant-item:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
}

.merchant-content {
  padding: 20px;
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 100%; /* 让内容填充整个卡片 */
}

.merchant-logo {
  width: 80px;
  height: 80px;
  object-fit: cover;
  border-radius: 50%;
  margin-bottom: 15px;
  transition: transform 0.3s ease;
}

.merchant-item:hover .merchant-logo {
  transform: scale(1.1);
}

.merchant-info h3 {
  font-size: 1.4em;
  margin-bottom: 10px;
  color: #333;
  font-weight: 600;
}

.merchant-info p {
  font-size: 1em;
  color: #666;
  margin-bottom: 15px;
  line-height: 1.6;
}

button {
  background-color: #007bff;
  color: #ffffff;
  border: none;
  padding: 10px 25px;
  border-radius: 30px;
  cursor: pointer;
  font-size: 1rem;
  transition: background-color 0.3s ease, transform 0.2s ease;
}

button:hover {
  background-color: #0056b3;
  transform: scale(1.05);
}

button:active {
  background-color: #003f7f;
}
</style>
