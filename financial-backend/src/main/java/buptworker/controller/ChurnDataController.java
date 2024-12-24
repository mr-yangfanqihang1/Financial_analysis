package buptworker.controller;

import buptworker.entity.Result;
import buptworker.entity.UserP;
import buptworker.service.ChurnDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7000", allowCredentials = "true")
@RequestMapping("/api")
public class ChurnDataController {

    @Autowired
    private ChurnDataService churnDataService;

    @RequestMapping("/getChurnData")
    public Result getChurnData() {
        // 调用 Service 层获取数据
        List<UserP> topUsers = churnDataService.getTopChurnUsers();
        return Result.success(topUsers);
    }
}
