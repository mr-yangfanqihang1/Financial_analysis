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
<template>
  <div class="merchant-recommendation">
    <h2>推荐商家</h2>
    <div class="merchant-list">
      <div v-for="merchant in merchants" :key="merchant.id" class="merchant-item">
        <img :src="merchant.logo" alt="{{ merchant.name }} logo" class="merchant-logo" />
        <div class="merchant-info">
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
      ]
    }
  },
  methods: {
    visitMerchant (link) {
      window.open(link, '_blank')
    }
  }
}
</script>

<style scoped>
.merchant-recommendation {
  padding: 20px;
  background-color: #f9f9f9;
}

.merchant-list {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
}

.merchant-item {
  background: #ffffff;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  transition: box-shadow 0.3s ease;
}

.merchant-item:hover {
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
}

.merchant-logo {
  width: 100%;
  height: 150px;
  object-fit: cover;
}

.merchant-info {
  padding: 15px;
  text-align: center;
}

.merchant-info h3 {
  margin-bottom: 10px;
  font-size: 1.2em;
  color: #333;
}

.merchant-info p {
  font-size: 0.95em;
  color: #666;
  margin-bottom: 15px;
}

button {
  background-color: #007bff;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

/* 右边白色区域样式 */
.content {
  width: 80%;
  background-color: white;
  padding: 20px;
}
</style>
