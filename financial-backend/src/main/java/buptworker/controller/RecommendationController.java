package buptworker.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:7001", allowCredentials = "true")
public class RecommendationController {

    @PostMapping("/recommend")
    public ResponseEntity<?> getRecommendations(@RequestBody Map<String, Object> request) {
        String merchantId = request.get("merchant_id").toString();

        String url = "http://localhost:5000/recommend";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> requestBody = Map.of("merchant_id", merchantId);

        try {
            // 调用 Python 服务
            ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);
            if (response.getBody() == null) {
                throw new Exception("Python service returned null response");
            }
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while calling recommendation service: " + e.getMessage());
        }
    }
}

//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.HttpStatus;
//
//import java.util.HashMap;
//import java.util.Map;


//@RestController
//@RequestMapping("/api")
//
//
//public class RecommendationController {
//
//    @PostMapping("/recommend")
//    public ResponseEntity<?> getRecommendations(@RequestBody Map<String, Object> request) {
//        // 获取merchant_id
//        String merchantId = request.get("merchant_id").toString();
//
//        // 调用Python服务
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:5000/recommend";
//        Map<String, String> requestBody = new HashMap<>();
//        requestBody.put("merchant_id", merchantId);
//
//        try {
//            // 发送POST请求
//            ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);
//
//            // 返回推荐用户
//            return ResponseEntity.ok(response.getBody());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while calling recommendation service");
//        }
//    }
//}
//
//@RestController
//@RequestMapping("/api")
//public class RecommendationController {
//
//    @PostMapping("/recommend")
//    public ResponseEntity<?> getRecommendations(@RequestBody Map<String, Object> request) {
//        String merchantId = request.get("merchant_id").toString();
//
//        String url = "http://localhost:5000/recommend";
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> requestBody = new HashMap<>();
//        requestBody.put("merchant_id", merchantId);
//
//        try {
//            // 调用 Python 服务
//            ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);
//            return ResponseEntity.ok(response.getBody());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error while calling recommendation service");
//        }
//    }
//}

