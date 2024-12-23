package buptworker.entity;

import java.math.BigDecimal;

public class Transaction {
    private Long id;
    private Long merchant_id;
    private String is_fraudulent;
    private BigDecimal amount; // Decimal type
    private String date;
    private String use_chip;
    private String merchant_state;
    private String mcc;
    private Integer client_id; // Should be Integer, not String
    private Integer credit_score;
    private Integer current_age;
    private String gender;
    private String yearly_income; // String for varchar(50)
    private String total_debt;    // String for varchar(50)
    private Integer num_credit_cards;
    private String card_type;
    private String credit_limit; // String for varchar(50)
    private Integer year_pin_last_changed;
    private String has_chip; // String for varchar(3)
    private String prediction;

    @Override
    public String toString() {
        return "Transaction{" +
                ", merchant_id=" + merchant_id +
                ", is_fraudulent='" + is_fraudulent + '\'' +
                ", prediction=" + prediction +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", use_chip='" + use_chip + '\'' +
                ", merchant_state='" + merchant_state + '\'' +
                ", mcc='" + mcc + '\'' +
                ", client_id=" + client_id +
                ", credit_score=" + credit_score +
                ", current_age=" + current_age +
                ", gender='" + gender + '\'' +
                ", yearly_income='" + yearly_income + '\'' +
                ", total_debt='" + total_debt + '\'' +
                ", num_credit_cards=" + num_credit_cards +
                ", card_type='" + card_type + '\'' +
                ", credit_limit='" + credit_limit + '\'' +
                ", year_pin_last_changed=" + year_pin_last_changed +
                ", has_chip='" + has_chip + '\'' +
                '}';
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(Long merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getIs_fraudulent() {
        return is_fraudulent;
    }

    public void setIs_fraudulent(String is_fraudulent) {
        this.is_fraudulent = is_fraudulent;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUse_chip() {
        return use_chip;
    }

    public void setUse_chip(String use_chip) {
        this.use_chip = use_chip;
    }

    public String getMerchant_state() {
        return merchant_state;
    }

    public void setMerchant_state(String merchant_state) {
        this.merchant_state = merchant_state;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }

    public Integer getCurrent_age() {
        return current_age;
    }

    public void setCurrent_age(Integer current_age) {
        this.current_age = current_age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYearly_income() {
        return yearly_income;
    }

    public void setYearly_income(String yearly_income) {
        this.yearly_income = yearly_income;
    }

    public String getTotal_debt() {
        return total_debt;
    }

    public void setTotal_debt(String total_debt) {
        this.total_debt = total_debt;
    }

    public Integer getNum_credit_cards() {
        return num_credit_cards;
    }

    public void setNum_credit_cards(Integer num_credit_cards) {
        this.num_credit_cards = num_credit_cards;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(String credit_limit) {
        this.credit_limit = credit_limit;
    }

    public Integer getYear_pin_last_changed() {
        return year_pin_last_changed;
    }

    public void setYear_pin_last_changed(Integer year_pin_last_changed) {
        this.year_pin_last_changed = year_pin_last_changed;
    }

    public String getHas_chip() {
        return has_chip;
    }

    public void setHas_chip(String has_chip) {
        this.has_chip = has_chip;
    }
}
