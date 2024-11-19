<template>
    <div class="fraud-detection">
      <el-container>
        <!-- 标题 -->
        <el-header>
          <h1>交易欺诈检测</h1>
        </el-header>
  
        <!-- 内容 -->
        <el-main>
          <!-- 饼状图和折线图 -->
          <div class="chart-section">
            <el-row :gutter="20">
              <!-- 饼状图：欺诈比例 -->
              <el-col :span="12">
                <el-card>
                  <h2>欺诈比例</h2>
                  <vue-chartjs :data="pieChartData" :options="chartOptions" />
                </el-card>
              </el-col>
  
              <!-- 折线图：最近30天欺诈趋势 -->
              <el-col :span="12">
                <el-card>
                  <h2>最近30天欺诈趋势</h2>
                  <vue-chartjs-line :data="lineChartData" :options="chartOptions" />
                </el-card>
              </el-col>
            </el-row>
          </div>
  
          <!-- 检测按钮 -->
          <div class="action-section">
            <el-button
              type="primary"
              size="large"
              icon="el-icon-search"
              round
              @click="openDialog"
            >
              开始欺诈检测
            </el-button>
          </div>
        </el-main>
  
        <!-- 表单弹窗 -->
        <el-dialog
          title="欺诈检测表单"
          :visible.sync="dialogVisible"
          width="50%"
        >
          <el-form :model="form" label-width="120px">
            <el-form-item label="日期">
              <el-date-picker
                v-model="form.date"
                type="datetime"
                placeholder="选择日期时间"
              />
            </el-form-item>
            <el-form-item label="客户ID">
              <el-input v-model="form.client_id" type="number" />
            </el-form-item>
            <el-form-item label="银行卡ID">
              <el-input v-model="form.card_id" type="number" />
            </el-form-item>
            <el-form-item label="交易金额">
              <el-input v-model="form.amount" type="number" />
            </el-form-item>
            <el-form-item label="芯片使用情况">
              <el-input v-model="form.use_chip" />
            </el-form-item>
            <el-form-item label="商户ID">
              <el-input v-model="form.merchant_id" type="number" />
            </el-form-item>
            <el-form-item label="商户城市">
              <el-input v-model="form.merchant_city" />
            </el-form-item>
            <el-form-item label="商户州">
              <el-input v-model="form.merchant_state" />
            </el-form-item>
            <el-form-item label="邮编">
              <el-input v-model="form.zip" type="number" />
            </el-form-item>
            <el-form-item label="MCC代码">
              <el-input v-model="form.mcc" type="number" />
            </el-form-item>
            <el-form-item label="错误信息">
              <el-input v-model="form.errors" />
            </el-form-item>
          </el-form>
  
          <!-- 按钮 -->
          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="analyzeFraud">提交检测</el-button>
          </span>
        </el-dialog>
  
        <!-- 检测结果 -->
        <div v-if="analysisResult !== null" class="result-section">
          <el-card>
            <h3>检测结果</h3>
            <p>是否为欺诈交易：{{ analysisResult.is_fraudulent }}</p>
          </el-card>
        </div>
      </el-container>
    </div>
  </template>
  
  <script>
  import { Pie, Line } from "vue-chartjs"; // 使用饼状图和折线图
  import { Chart, registerables } from "chart.js";
  
  Chart.register(...registerables);
  
  export default {
    name: "FraudDetection",
    components: {
      vueChartjs: Pie,
      vueChartjsLine: Line,
    },
    data() {
      return {
        dialogVisible: false, // 控制弹窗显示
        form: {
          date: null,
          client_id: null,
          card_id: null,
          amount: null,
          use_chip: "",
          merchant_id: null,
          merchant_city: "",
          merchant_state: "",
          zip: null,
          mcc: null,
          errors: "",
        },
        analysisResult: null, // 保存分析结果
        pieChartData: {
          labels: ["欺诈", "非欺诈"],
          datasets: [
            {
              label: "欺诈比例",
              backgroundColor: ["#FF6384", "#36A2EB"],
              data: [30, 70], // 示例数据
            },
          ],
        },
        lineChartData: {
          labels: Array.from({ length: 30 }, (_, i) => `Day ${i + 1}`), // 最近30天
          datasets: [
            {
              label: "欺诈数量",
              backgroundColor: "#FF6384",
              borderColor: "#FF6384",
              fill: false,
              data: Array.from({ length: 30 }, () => Math.floor(Math.random() * 20)), // 随机生成示例数据
            },
            {
              label: "欺诈比例",
              backgroundColor: "#36A2EB",
              borderColor: "#36A2EB",
              fill: false,
              data: Array.from({ length: 30 }, () => Math.random().toFixed(2) * 100), // 随机生成比例数据
            },
          ],
        },
        chartOptions: {
          responsive: true,
          maintainAspectRatio: false,
        },
      };
    },
    methods: {
      openDialog() {
        this.dialogVisible = true;
      },
      async analyzeFraud() {
        try {
          // 模拟调用后端模型
          const response = await this.$http.post("/api/analyze", this.form); // 替换为实际接口
          this.analysisResult = response.data;
          this.dialogVisible = false;
        } catch (error) {
          console.error("分析失败:", error);
          this.$message.error("欺诈检测失败，请重试！");
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .fraud-detection {
    padding: 20px;
  }
  
  .chart-section {
    margin-bottom: 20px;
  }
  
  .action-section {
    text-align: center;
    margin-bottom: 20px;
  }
  
  .result-section {
    margin-top: 20px;
  }
  </style>
  