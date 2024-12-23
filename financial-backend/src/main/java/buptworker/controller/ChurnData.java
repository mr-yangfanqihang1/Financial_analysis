package buptworker.controller;

import buptworker.entity.Result;
import buptworker.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : [Xieyx]
 * @version : [v1.0]
 */

@RestController
@CrossOrigin(origins = "http://localhost:7000", allowCredentials = "true")
@RequestMapping("/api")
public class ChurnData {
    private SessionUtil cookie;
//    @Autowired
//    private MchAnalysisService mchAnalysisService;

    // 全部商家统计
//    @RequestMapping("/getOfflineMchTotalMessage")
//    public Result getOfflineMchTotalMessage(){
//        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(100,1000,10000));
//        return Result.success(l);
//    }


}
