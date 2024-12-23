package buptworker.entity;

public class StatisticsData {
    //商家总数   总销售额   总销量
    Integer total_merchants;
    Integer total_sales;
    Integer total_transactions;


    public StatisticsData(Integer mchNum, Integer totalSalePrice, Integer totalSaleCount) {
        this.total_merchants = mchNum;
        this.total_sales = totalSalePrice;
        this.total_transactions = totalSaleCount;
    }

    public Integer getMchNum() {
        return total_merchants;
    }

    public void setMchNum(Integer mchNum) {
        this.total_merchants = mchNum;
    }

    public Integer getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(Integer total_sales) {
        this.total_sales = total_sales;
    }

    public Integer getTotal_transactions() {
        return total_transactions;
    }

    public void setTotal_transactions(Integer total_transactions) {
        this.total_transactions = total_transactions;
    }

    @Override
    public String toString() {
        return "statisticsData{" +
                "mchNum=" + total_merchants +
                ", totalSalePrice=" + total_sales +
                ", totalSaleCount=" + total_transactions +
                '}';
    }
}
