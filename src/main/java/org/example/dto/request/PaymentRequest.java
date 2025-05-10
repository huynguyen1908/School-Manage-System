package org.example.dto.request;

import java.math.BigDecimal;

public class PaymentRequest {
    private String tuitionId;
    private BigDecimal amount;
    private String paymentMethod;
    private String transactionId;
    
    // Getters and setters
    public String getTuitionId() { return tuitionId; }
    public void setTuitionId(String tuitionId) { this.tuitionId = tuitionId; }
    
    // For backward compatibility
    public String getTuitionFeeId() { return tuitionId; }
    public void setTuitionFeeId(String id) { this.tuitionId = id; }
    
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
