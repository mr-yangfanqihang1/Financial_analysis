<template>
  <div class="merchant-recommendation">
    <h2>商家推荐</h2>
    <div class="merchant-cards">
      <div v-for="merchant in merchants" :key="merchant.id" class="merchant-card">
        <div class="merchant-card-content">
          <img :src="merchant.image" alt="Merchant Image" class="merchant-image" />
          <h3>{{ merchant.name }}</h3>
          <p>{{ merchant.description }}</p>
          <button @click="goToMerchant(merchant.link)">查看详情</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MerchantRecommendation',
  data() {
    return {
      merchants: [
        {
          id: 1,
          name: '商家A',
          description: '高质量产品，优质服务',
          image: 'https://example.com/merchant-a.jpg',
          link: 'https://example.com/merchant-a'
        },
        {
          id: 2,
          name: '商家B',
          description: '经济实惠，值得信赖',
          image: 'https://example.com/merchant-b.jpg',
          link: 'https://example.com/merchant-b'
        },
        // 其他商家信息
      ]
    };
  },
  methods: {
    goToMerchant(link) {
      window.location.href = link;
    }
  }
};
</script>

<style scoped>
.merchant-recommendation {
  padding: 20px;
}

.merchant-cards {
  display: flex;
  gap: 20px;
  flex-wrap: wrap;
}

.merchant-card {
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 16px;
  width: 200px;
  text-align: center;
  transition: transform 0.3s;
}

.merchant-card:hover {
  transform: translateY(-5px);
}

.merchant-image {
  width: 100%;
  height: 120px;
  object-fit: cover;
  border-radius: 8px;
  margin-bottom: 12px;
}

button {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 8px 16px;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
