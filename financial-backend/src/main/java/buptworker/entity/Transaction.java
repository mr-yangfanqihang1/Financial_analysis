package buptworker.entity;

import java.math.BigDecimal;

public class Transaction {

    private Long id;
    private Long merchantId;
    private Boolean isFraudulent;
    private Boolean prediction;
    private Double amount;
    private String date;
    private String useChip;
    private String merchantState;
    private String mcc;
    private String clientId;
    private Integer creditScore;
    private Integer currentAge;
    private String gender;
    private BigDecimal yearlyIncome;
    private BigDecimal totalDebt;
    private Integer numCreditCards;
    private String cardType;
    private BigDecimal creditLimit;
    private Integer yearPinLastChanged;
    private Boolean hasChip;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Boolean getIsFraudulent() {
        return isFraudulent;
    }

    public void setIsFraudulent(Boolean isFraudulent) {
        this.isFraudulent = isFraudulent;
    }

    public Boolean getPrediction() {
        return prediction;
    }

    public void setPrediction(Boolean prediction) {
        this.prediction = prediction;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUseChip() {
        return useChip;
    }

    public void setUseChip(String useChip) {
        this.useChip = useChip;
    }

    public String getMerchantState() {
        return merchantState;
    }

    public void setMerchantState(String merchantState) {
        this.merchantState = merchantState;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Integer getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(Integer currentAge) {
        this.currentAge = currentAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(BigDecimal yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public BigDecimal getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(BigDecimal totalDebt) {
        this.totalDebt = totalDebt;
    }

    public Integer getNumCreditCards() {
        return numCreditCards;
    }

    public void setNumCreditCards(Integer numCreditCards) {
        this.numCreditCards = numCreditCards;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getYearPinLastChanged() {
        return yearPinLastChanged;
    }

    public void setYearPinLastChanged(Integer yearPinLastChanged) {
        this.yearPinLastChanged = yearPinLastChanged;
    }

    public Boolean getHasChip() {
        return hasChip;
    }

    public void setHasChip(Boolean hasChip) {
        this.hasChip = hasChip;
    }
}