<template>
  <el-container>
    <!-- 标题 -->
    <el-header>
      <h1>交易欺诈检测</h1>
    </el-header>

    <!-- 内容区域 -->
    <el-main>
      <el-row :gutter="20">
        <!-- 饼状图 -->
        <el-col :span="12">
          <el-card class="chart-card">
            <v-chart :option="pieChartOption" style="width: 100%; height: 350px;" />
          </el-card>
        </el-col>

        <!-- 折线图 -->
        <el-col :span="12">
          <el-card class="chart-card">
            <v-chart :option="lineChartOption" style="width: 100%; height: 350px;" />
          </el-card>
        </el-col>
      </el-row>

      <!-- 操作按钮 -->
      <div class="action-section">
        <el-button type="primary" size="large" @click="openDialog" icon="el-icon-search" round>
          开始欺诈检测
        </el-button>
        <el-button
          type="success"
          size="large"
          @click="importJson"
          icon="el-icon-upload"
          round
        >
          批量检测
        </el-button>
        <input
          type="file"
          ref="fileInput"
          style="display: none"
          @change="handleFileUpload"
          accept=".json"
        />
      </div>

      <!-- 表单弹窗 -->
      <el-dialog title="欺诈检测表单" :visible.sync="dialogVisible" width="50%">
        <el-form :model="form" label-width="120px">
          <el-form-item label="日期">
            <el-date-picker v-model="form.date" type="datetime" placeholder="选择日期" />
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
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="submitForm">提交</el-button>
        </span>
      </el-dialog>

      <!-- 表格展示导入数据和检测结果 -->
      <el-table :data="tableData" border style="margin-top: 20px" v-if="tableData.length">
        <el-table-column prop="date" label="日期" width="150"></el-table-column>
        <el-table-column prop="client_id" label="客户ID" width="100"></el-table-column>
        <el-table-column prop="card_id" label="银行卡ID" width="100"></el-table-column>
        <el-table-column prop="amount" label="交易金额" width="100"></el-table-column>
        <el-table-column prop="use_chip" label="芯片使用情况" width="120"></el-table-column>
        <el-table-column prop="merchant_id" label="商户ID" width="100"></el-table-column>
        <el-table-column prop="merchant_city" label="商户城市" width="120"></el-table-column>
        <el-table-column prop="merchant_state" label="商户州" width="100"></el-table-column>
        <el-table-column prop="zip" label="邮编" width="100"></el-table-column>
        <el-table-column prop="mcc" label="MCC代码" width="100"></el-table-column>
        <el-table-column prop="errors" label="错误信息" width="150"></el-table-column>
        <el-table-column prop="result" label="检测结果" width="120"></el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: "FraudDetection",
  data() {
    return {
      dialogVisible: false,
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
      tableData: [],
      pieChartOption: {
        title: {
          text: "今日欺诈比例",
          left: "center",
        },
        tooltip: {
          trigger: "item",
        },
        legend: {
          orient: "horizontal",
          bottom: "10%",
        },
        series: [
          {
            name: "比例",
            type: "pie",
            radius: "50%",
            data: [
              { value: 10, name: "欺诈" },
              { value: 90, name: "非欺诈" },
            ],
          },
        ],
      },
      lineChartOption: {
        title: {
          text: "最近30天欺诈趋势",
          left: "center",
        },
        tooltip: {
          trigger: "axis",
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: Array.from({ length: 30 }, (_, i) => `Day ${i + 1}`),
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            name: "欺诈数量",
            type: "line",
            smooth: true,
            data: Array.from({ length: 30 }, () => Math.floor(Math.random() * 20)),
            itemStyle: {
              color: "#FF6384",
            },
          },
        ],
      },
    };
  },
  methods: {
    openDialog() {
      this.dialogVisible = true;
    },
    submitForm() {
      console.log("提交表单：", this.form);
      this.dialogVisible = false;
    },
    importJson() {
      this.$refs.fileInput.click();
    },
    handleFileUpload(event) {
      const file = event.target.files[0];
      if (!file) return;
      const reader = new FileReader();
      reader.onload = (e) => {
        try {
          const data = JSON.parse(e.target.result);
          this.tableData = data.map((item) => ({
            ...item,
            result: Math.random() > 0.5 ? "欺诈" : "非欺诈", // 模拟检测结果
          }));
        } catch (err) {
          this.$message.error("文件解析失败，请检查文件格式！");
        }
      };
      reader.readAsText(file);
    },
  },
};
</script>

<style scoped>
.chart-card {
  height: 400px;
}

.action-section {
  text-align: center;
  margin: 20px 0;
}
</style>
