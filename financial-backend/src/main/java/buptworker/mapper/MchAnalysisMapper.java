package buptworker.mapper;

import buptworker.entity.StatisticsData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Mapper
public interface MchAnalysisMapper {

    @Select("SELECT " +
            "COUNT(DISTINCT td.merchant_id) AS total_merchants, " +
            "SUM(td.amount) AS total_sales, " +
            "COUNT(td.id) AS total_transactions " +
            "FROM transactions_data td " +
            "WHERE td.date >= DATE_SUB('2015-01-01', INTERVAL 1 WEEK) " +
            "AND td.date < '2015-01-01';")
    StatisticsData getOfflineMchTotalMessage();

    @Select("SELECT " +
            "COUNT(DISTINCT td.merchant_id) AS total_merchants, " +
            "SUM(td.amount) AS total_sales, " +
            "COUNT(td.id) AS total_transactions " +
            "FROM transactions_data td " +
            "WHERE td.date >= #{startOfDay} " +
            "AND td.date < #{endOfDay};")
    ArrayList<Integer>  getRealtimeMchTotalMessage(LocalDateTime startOfDay, LocalDateTime endOfDay);
}
