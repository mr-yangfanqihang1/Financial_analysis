package buptworker.service;



import buptworker.entity.UserP;

import buptworker.mapper.ChurnDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChurnDataService {

    @Autowired
    private ChurnDataMapper predictionsMapper;

    private final SimulatedTimeService simulatedTimeService;

    @Autowired
    public ChurnDataService(SimulatedTimeService simulatedTimeService) {
        this.simulatedTimeService = simulatedTimeService;
    }


    public List<UserP> getTopChurnUsers() {
        LocalDateTime simulatedTime = simulatedTimeService.getSimulatedCurrentTime();

        LocalDate simulatedDate = simulatedTime.toLocalDate();
        // 模拟日期为 2019-06-01
        String date = "2019-06-01";

        // 查询当天流失概率最高的前 12 人
        return predictionsMapper.findTopChurnUsers(simulatedDate.toString(), 30);
    }
}
