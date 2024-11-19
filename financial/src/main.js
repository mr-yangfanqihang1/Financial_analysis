import Vue from "vue";
import App from "./App.vue";
import router from "./router"; // 如果有路由
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import ECharts from "vue-echarts";
import "echarts";

Vue.use(ElementUI);
Vue.component("v-chart", ECharts);

Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");

