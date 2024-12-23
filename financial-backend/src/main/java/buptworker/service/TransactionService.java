package buptworker.service;
import buptworker.entity.Transaction;
import buptworker.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    // 获取所有交易数据
    public List<Transaction> getAllTransactions() {
        return transactionMapper.getAllTransactions();
    }

    // 保存预测结果
    public void savePredictionResults(List<Map<String, Object>> results) {
        for (Map<String, Object> result : results) {
            // 从结果中获取预测数据
            Long merchantId = ((Number) result.get("merchant_id")).longValue();
            Boolean isFraudulent = ((Number) result.get("is_fraudulent")).intValue() == 1;
            Boolean prediction = ((Number) result.get("prediction")).intValue() == 1;

            // 查找数据库中的交易记录
            Transaction transaction = transactionMapper.findTransactionByMerchantId(merchantId);

            // 如果记录存在，则更新预测结果
            if (transaction != null) {
                transaction.setIsFraudulent(isFraudulent);
                transaction.setPrediction(prediction);
                transactionMapper.updateTransaction(transaction); // 保存更新后的记录
            }
        }
    }
}