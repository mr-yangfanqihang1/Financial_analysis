package buptworker.service;
import buptworker.entity.Transaction;
import buptworker.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


@Service
@EnableAsync
public class TransactionService {


    public List<Transaction> getAllTransactions() {
        return transactionMapper.getAllTransactions();
    }

// 创建一个阻塞队列用于存放待处理的数据
    private BlockingQueue<List<Map<String, Object>>> queue = new LinkedBlockingQueue<>(100);

    // 使用线程池处理消费者任务
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Autowired
    private TransactionMapper transactionMapper;

    // 生产者方法，接收数据并将其放入队列
    public List<Map<String, Object>> savePredictionResultsAsync(List<Map<String, Object>> results) {
        // 立即返回，处理数据放入队列
        queue.offer(results);

        // 启动消费者线程，开始处理队列中的数据
        executorService.submit(this::processPredictionResults);

        // 构造返回结果
        List<Map<String, Object>> outputResults = new ArrayList<>();
        for (Map<String, Object> result : results) {
            int predictionValue = ((Number) result.get("prediction")).intValue();
            String prediction = predictionValue == 1 ? "Yes" : "No";

            // 构建返回值，立即响应
            Map<String, Object> output = new HashMap<>();
            output.put("id", result.get("id"));
            output.put("prediction", prediction);
            outputResults.add(output);
        }

        // 返回结果
        return outputResults;
    }

    // 消费者方法，处理队列中的数据
    @Async
    public void processPredictionResults() {
        try {
            // 从队列中获取数据进行处理
            List<Map<String, Object>> results = queue.take();

            for (Map<String, Object> result : results) {
                try {
                    // 从结果中获取预测数据
                    Long id = ((Number) result.get("id")).longValue();
                    int predictionValue = ((Number) result.get("prediction")).intValue();

                    // 转换 prediction 为 "No" 或 "Yes"
                    String prediction = predictionValue == 1 ? "Yes" : "No";

                    // 查找数据库中的交易记录
                    Transaction transaction = transactionMapper.findTransactionById(id);

                    // 如果记录存在，则更新预测结果
                    if (transaction != null) {
                        transaction.setPrediction(prediction);
                        transactionMapper.updateTransaction(transaction);
                    }

                    System.out.println("预测值已写入数据库，ID: " + id + ", Prediction: " + prediction);
                } catch (Exception e) {
                    System.err.println("处理结果时发生错误：" + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            System.err.println("处理队列时发生错误：" + e.getMessage());
        }
    }
}



