package buptworker.service;

import buptworker.entity.StatisticsData;
import buptworker.mapper.MchAnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@Service
public class MchAnalysisService {

    @Autowired
    private SimulatedTimeService simulatedTimeService;

    @Autowired
    private MchAnalysisMapper mchAnalysisMapper;

    public ArrayList<Integer>  getOfflineMchTotalMessage(){
        StatisticsData l = mchAnalysisMapper.getOfflineMchTotalMessage();
        System.out.println(l.toString());
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(l.getMchNum());
        ls.add(l.getTotal_sales());
        ls.add(l.getTotal_transactions());
        return ls;
    }

    public ArrayList<Integer>  getRealtimeMchTotalMessage(){
        LocalDateTime localDateTime = simulatedTimeService.getSimulatedCurrentTime();
        LocalDateTime startOfDay = getStartOfDay(localDateTime);
        LocalDateTime endOfDay = getEndOfDay(localDateTime);
        return mchAnalysisMapper.getRealtimeMchTotalMessage(startOfDay, endOfDay);
    }


    public static LocalDateTime getStartOfDay(LocalDateTime localDateTime) {
        // 使用 LocalDate 的 atStartOfDay() 方法来获取当天的开始时间
        return localDateTime.toLocalDate().atStartOfDay();
    }

    /**
     * 计算给定时间的当天结束时间 (23:59:59.999999999)
     */
    public static LocalDateTime getEndOfDay(LocalDateTime localDateTime) {
        // 获取当天的最后时刻
        return localDateTime.toLocalDate().atTime(LocalTime.MAX);
    }

}
