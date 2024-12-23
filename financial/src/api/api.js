// 引入 axios 库，axios 是一个基于 Promise 的 HTTP 库，用于发送 HTTP 请求
import axios from 'axios';

/**
 * 创建一个 axios 实例
 * 
 * 这个实例可以用来发送 HTTP 请求，并且可以在这里配置基础的 URL 和其他默认设置。
 */
// const apiClient = axios.create({
//   // 设置基础 URL，所有请求都会基于这个 URL
//   baseURL: 'https://api.example.com',
//   // 设置请求的超时时间（10秒）
//   timeout: 10000,
//   // 设置默认的请求头，表示发送的内容是 JSON 格式
//   headers: {
//     'Content-Type': 'application/json'
//   }
// });
const apiClient = axios.create({
  baseURL: 'http://localhost:8081/', // 根据你的后端服务地址调整
  timeout: 10000, // 请求超时时间
//   withCredentials: true,              // 允许发送 Cookie
})

/**
 * 导出一个包含 API 请求方法的对象
 */

export default {
 
  /**
   * 获取离线整体商家统计信息（总数，销售额，销量）
   * [xieyx]
   * 
   * @returns {Promise} Promise
   */
  async getOfflineMchTotalMessage(){
    return apiClient.get(`/api/getOfflineMchTotalMessage`)
  },

   /**
   * 获取实时整体商家统计信息（总数，销售额，销量）
   * [xieyx]
   * 
   * @returns {Promise} Promise
   */
   async getRealtimeMchTotalMessage(){
    return apiClient.get(`/api/getRealtimeMchTotalMessage`)
  },

  /**
   * 获取离线商家整体统计图表数据
   * [xieyx]
   * @returns {Promise} Promise
   */
  async getOfflineMchTotalChartData(){
    return apiClient.get(`/api/getOfflineMchTotalChartData`)
  },


  /**
   * 获取实时商家整体统计图表数据
   * [xieyx]
   * @returns {Promise} Promise
   */
  async getRealtimeMchTotalChartData(){
    return apiClient.get(`/api/getRealtimeMchTotalChartData`)
  },

  /**
   * 获取具体某一商家统计数据
   * [xieyx]
   * @param {*} Mchid 商家ID
   * @returns {Promise} Promise
   */
  async getMerchantStats(Mchid){
    return apiClient.get(`/api/getMchStats?Mchid=${Mchid}`)
  },
  
  /**
   * 获取潜在流失用户
   * @returns {Promise} Promise
   */
  async getChurnData(){
    return apiClient.get(`/api/getChurnData`)
  }
  

 
};
/**
 * 使用示例：
 * 
 * import api from './path/to/api';
 * 
 * api.getItems()
 *   .then(response => {
 *     // 在这里处理成功响应，response.data 包含服务器返回的数据
 *     console.log('商品列表:', response.data);
 *   })
 *   .catch(error => {
 *     // 在这里处理错误响应
 *     console.error('获取商品列表时出错:', error);
 *   });
 */

/*

getMerchantTypes() {
    return apiClient.get(`/api/merchant-type`);
  },
*/