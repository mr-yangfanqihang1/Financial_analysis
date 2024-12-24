package buptworker.mapper;

import buptworker.entity.UserP;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChurnDataMapper {

    @Select("SELECT client_id AS id, probability AS p " +
            "FROM predictions " +
            "WHERE transaction_date = #{date} " +
            "ORDER BY probability DESC " +
            "LIMIT #{limit}")
    List<UserP> findTopChurnUsers(@Param("date") String date, @Param("limit") int limit);
}
