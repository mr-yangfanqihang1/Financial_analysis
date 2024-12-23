package buptworker.controller;

import buptworker.entity.Result;
import buptworker.entity.user_res;
import buptworker.service.MchAnalysisService;
import buptworker.service.UserRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7000", allowCredentials = "true")
@RequestMapping("/api")
public class UserRecommend {

    @Autowired
    private UserRecommendService userRecommendService;

    @RequestMapping("/getfourint")
    public Result getRecommendUserName(String userId) throws IOException {
        List<user_res> res = new ArrayList<>();
        res.add(new user_res("27092", "Money Transfer"));
        res.add(new user_res("61195", "Service Stations"));
        res.add(new user_res("69972", "Fast Food Restaurants"));
        res.add(new user_res("73838", "Lumber and Building Materials"));
        return Result.success(res);
    }

}


