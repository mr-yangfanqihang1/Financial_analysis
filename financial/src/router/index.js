import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/ClientCredit',
    name: 'clientcredit',
    component: () => import(/* webpackChunkName: "about" */ '../views/ClientCredit.vue')
  },
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.E:\BigDataProject\Financial_analysis\financial\src\views\MchRecommend.vue
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // },
  {
    path: '/MchRecommend',
    name: 'MchRecommend',
    component: () => import(/* webpackChunkName: "about" */ '../views/MchRecommend.vue')
  },
  {
    path: '/UserRecommend',
    name: 'UserRecommend',
    component: () => import(/* webpackChunkName: "about" */ '../views/UserRecommend.vue')
  }
  // {
  //   path: '/merchant',
  //   name: 'merchant',
  //   component: () => import('../views/MchRecommend.vue')
  // },

]

const router = new VueRouter({
  routes
})

export default router
