package buptworker.mapper;

import buptworker.entity.Transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TransactionMapper {

    // 查询欺诈预测所需的所有交易数据
    @Select("""
            SELECT 
                   t.id,
                   t.date,
                   t.amount,
                   t.use_chip,
                   t.merchant_id,
                   t.merchant_state,
                   t.is_fraudulent,
                   t.mcc,
                   t.client_id,
                   u.credit_score,
                   u.current_age,
                   u.gender,
                   u.yearly_income,
                   u.total_debt,
                   u.num_credit_cards,
                   c.card_type,
                   c.credit_limit,
                   c.year_pin_last_changed,
                   c.has_chip
            FROM transactions_data t
            JOIN users_data u ON t.client_id = u.id
            JOIN card_data c ON t.card_id = c.id
            WHERE t.is_fraudulent IS NOT NULL
            LIMIT 30000 OFFSET 5000000
            """)
    List<Transaction> getAllTransactions();

    // 根据 merchant_id 查找交易记录
    @Select("SELECT * FROM transactions_data WHERE id = #{id}")
    Transaction findTransactionById(@Param("id") Long id);

    // 更新交易记录的预测结果
    @Update("""
            UPDATE transactions_data 
            SET is_fraudulent = #{is_fraudulent}, 
                prediction = #{prediction}
            WHERE id = #{id}
            """)
    void updateTransaction(Transaction transaction);
}
