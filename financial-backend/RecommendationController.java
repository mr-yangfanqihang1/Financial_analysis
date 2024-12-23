@RestController
@RequestMapping("/api")
public class RecommendationController {

    @PostMapping("/recommend")
    public ResponseEntity<?> getRecommendations(@RequestBody Map<String, Object> request) {
        // 获取merchant_id
        String merchantId = request.get("merchant_id").toString();

        // 调用Python服务
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:5000/recommend";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("merchant_id", merchantId);

        try {
            // 发送POST请求
            ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);

            // 返回推荐用户
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while calling recommendation service");
        }
    }
}
