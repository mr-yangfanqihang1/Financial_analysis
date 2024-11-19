import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: HomeView,
    children: [
      {
        path: "",
        name: "home", // 主页面默认显示内容
        component: () =>
          import(
            /* webpackChunkName: "HomeContent" */ "../views/HomeContent.vue"
          ),
      },
      {
        path: "FraudDetection",
        name: "FraudDetection",
        component: () =>
          import(
            /* webpackChunkName: "FraudDetection" */ "../views/FraudDetection.vue"
          ),
      },
      {
        path: "MchRecommend",
        name: "MchRecommend",
        component: () =>
          import(
            /* webpackChunkName: "MchRecommend" */ "../views/MchRecommend.vue"
          ),
      },
      {
        path: "UserRecommend",
        name: "UserRecommend",
        component: () =>
          import(
            /* webpackChunkName: "UserRecommend" */ "../views/UserRecommend.vue"
          ),
      },
      {
        path: "ClientCredit",
        name: "ClientCredit",
        component: () =>
          import(
            /* webpackChunkName: "ClientCredit" */ "../views/ClientCredit.vue"
          ),
      },
      {
        path: "MchAnalysis",
        name: "MchAnalysis",
        component: () =>
          import(
            /* webpackChunkName: "ClientCredit" */ "../views/MchAnalysis.vue"
          ),
      },
      // {
      //   path: "HealthCheck",
      //   name: "HealthCheck",
      //   component: () =>
      //     import(
      //       /* webpackChunkName: "HealthCheck" */ "../views/HealthCheck.vue"
      //     ),
      // },
    ],
  },
];

const router = new VueRouter({
  mode: "history", // 使用 HTML5 History 模式
  routes,
});

export default router;
