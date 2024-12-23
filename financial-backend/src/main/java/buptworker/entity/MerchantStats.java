package buptworker.entity;

import java.util.List;

// 商家统计数据
public class MerchantStats {

    private Stats stats;              // 商家统计信息
    private List<Integer> weeklySales;    // 近一周销量
    private List<Double> weeklyRevenue;  // 近一周销售额

    // Getters and Setters
    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Integer> getWeeklySales() {
        return weeklySales;
    }

    public void setWeeklySales(List<Integer> weeklySales) {
        this.weeklySales = weeklySales;
    }

    public List<Double> getWeeklyRevenue() {
        return weeklyRevenue;
    }

    public void setWeeklyRevenue(List<Double> weeklyRevenue) {
        this.weeklyRevenue = weeklyRevenue;
    }


}
