package buptworker.controller;
import buptworker.entity.Transaction;
import buptworker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // 获取交易数据接口
    @GetMapping
    public List<Transaction> getAllTransactions() {
        
        List<Transaction> result = transactionService.getAllTransactions();
        int maxRows = 5; // 要打印的最大行数
        for (int i = 0; i < Math.min(result.size(), maxRows); i++) {
            System.out.println(result.get(i));
        }
        return result;
    }

    // 接收 Python 的预测结果接口
    @PostMapping("/results")
    public String receivePredictionResults(@RequestBody List<Map<String, Object>> results) {
        List<Map<String, Object>> response = transactionService.savePredictionResultsAsync(results);

        // 打印接收到的预测结果
        System.out.println("接收到的预测结果：");
        results.forEach(System.out::println);
         // 立即返回响应

        return "预测结果接收成功！";
    }
}