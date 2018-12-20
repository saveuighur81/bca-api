package id.co.bca.sandbox.api_services.model.sakuku.create_payment;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class CreatePaymentRequest {
    private String merchantID;
    private String merchantName;
    private String amount;
    private String tax;
    private String transactionID;
    private String currencyCode;
    private String requestDate;
    private String referenceID;

    public CreatePaymentRequest(String merchantID, String merchantName, String amount, String tax, String transactionID, String currencyCode, String requestDate, String referenceID) {
        this.merchantID = merchantID;
        this.merchantName = merchantName;
        this.amount = amount;
        this.tax = tax;
        this.transactionID = transactionID;
        this.currencyCode = currencyCode;
        this.requestDate = requestDate;
        this.referenceID = referenceID;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }
}

