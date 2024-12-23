package buptworker.controller;
import buptworker.entity.Transaction;
import buptworker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return transactionService.getAllTransactions();
    }

    // 接收 Python 的预测结果接口
    @PostMapping("/results")
    public String receivePredictionResults(@RequestBody List<Map<String, Object>> results) {
        // 打印接收到的预测结果
        System.out.println("接收到的预测结果：");
        results.forEach(System.out::println);

        // 调用 Service 层保存预测结果到数据库
        transactionService.savePredictionResults(results);

        return "预测结果接收成功！";
    }
}