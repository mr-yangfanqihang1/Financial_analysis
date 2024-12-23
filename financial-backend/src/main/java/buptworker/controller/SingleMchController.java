package buptworker.controller;


import buptworker.entity.MerchantStats;

import buptworker.service.SingleMchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:7000", allowCredentials = "true")
@RequestMapping("/api")
public class SingleMchController {

    @Autowired
    private SingleMchService merchantService;

    // 获取商家统计数据
    @GetMapping("/getMchStats")
    public MerchantStats getMerchantStats(Integer Mchid) {
        return merchantService.getMerchantStats(Mchid);
    }
}
