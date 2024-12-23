package buptworker.controller;

import buptworker.service.SimulatedTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:7000", allowCredentials = "true")
public class SimulatedTimeController {

    @Autowired
    private SimulatedTimeService simulatedTimeService;

    // 获取当前模拟时间
    @GetMapping("/simulated-time")
    public LocalDateTime getSimulatedTime() {
        return simulatedTimeService.getSimulatedCurrentTime();
    }

    // 设置新的模拟速率（默认值为 60，即 1秒现实时间=1分钟模拟时间）
    @PostMapping("/speed")
    public String updateSimulationSpeed(@RequestParam long speed) {
        simulatedTimeService.setSimulationSpeed(speed);
        return "模拟速率已更新为: " + speed + " 倍";
    }

    // 重置模拟时间
    @PostMapping("/reset")
    public String resetSimulatedTime(@RequestParam String newTime) {
        LocalDateTime newSimulatedTime = LocalDateTime.parse(newTime);
        simulatedTimeService.resetSimulatedTime(newSimulatedTime);
        return "模拟时间已重置为: " + newTime;
    }
}
