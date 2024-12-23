package buptworker.service;


import buptworker.entity.MerchantStats;
import buptworker.entity.Stats;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SingleMchService {

    // 获取商家统计数据（这里只是示例，实际应该从数据库中获取）
    public MerchantStats getMerchantStats(Integer merchantId) {
        // 模拟数据（通常应从数据库查询）
        MerchantStats stats = new MerchantStats();

        // 商家统计信息
        Stats statsInfo = new Stats();
        statsInfo.setNewUsers(15);
        statsInfo.setTotalRevenue(12345.67);
        statsInfo.setTotalSales(456);

        stats.setStats(statsInfo);

        // 近一周的销量和销售额（示例数据）
        stats.setWeeklySales(Arrays.asList(50, 60, 70, 80, 90, 100, 110));
        stats.setWeeklyRevenue(Arrays.asList(600.0, 200.0, 700.0, 400.0, 500.0, 1000.0, 800.0));

        return stats;
    }
}
