//package buptworker.controller;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:7000", allowCredentials = "true")
//public class RecommendationController {
//
//    @PostMapping("/recommend")
//    public ResponseEntity<?> getRecommendations(@RequestBody Map<String, Object> request) {
//        String merchantId = request.get("merchant_id").toString();
//
//        String url = "http://localhost:5000/recommend";
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> requestBody = Map.of("merchant_id", merchantId);
//
//        try {
//            // 调用 Python 服务
//            ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);
//            if (response.getBody() == null) {
//                throw new Exception("Python service returned null response");
//            }
//            return ResponseEntity.ok(response.getBody());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error while calling recommendation service: " + e.getMessage());
//        }
//    }
//}
package buptworker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:7000", allowCredentials = "true")
public class RecommendationController {

    @PostMapping("/recommend")
    public ResponseEntity<?> getRecommendations(@RequestBody Map<String, Object> request) {
        String merchantId = request.get("merchant_id").toString();

        String url = "http://localhost:5000/recommend";
        RestTemplate restTemplate = new RestTemplate();

        // 创建请求体
        Map<String, Object> requestBody = Map.of("merchant_id", merchantId);

        try {
            // 调用 Python 服务
            ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);

            // 检查返回的响应体
            if (response.getBody() == null) {
                throw new Exception("Python service returned null response");
            }

            // 返回成功响应
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while calling recommendation service: " + e.getMessage());
        }
    }
}
