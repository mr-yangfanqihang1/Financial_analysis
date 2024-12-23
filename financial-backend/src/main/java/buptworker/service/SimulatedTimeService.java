package buptworker.service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class SimulatedTimeService {

    private LocalDateTime simulatedCurrentTime = LocalDateTime.of(2015, 1, 1, 0, 0); // 初始模拟时间
    private long simulationSpeed = 60; // 模拟速率：1秒现实时间 = 60秒模拟时间

    public LocalDateTime getSimulatedCurrentTime() {
        return simulatedCurrentTime;
    }

    public void setSimulationSpeed(long speed) {
        this.simulationSpeed = speed;
    }

    public void resetSimulatedTime(LocalDateTime newStartTime) {
        this.simulatedCurrentTime = newStartTime;
    }

    // 定时任务更新模拟时间，每秒更新一次
    @Scheduled(fixedRate = 1000) // 每秒运行一次
    public void updateSimulatedTime() {
        simulatedCurrentTime = simulatedCurrentTime.plus(simulationSpeed, ChronoUnit.SECONDS);
        System.out.println("当前模拟时间: " + simulatedCurrentTime);
    }
}
