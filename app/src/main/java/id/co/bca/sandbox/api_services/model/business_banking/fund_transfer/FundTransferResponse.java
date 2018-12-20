package id.co.bca.sandbox.api_services.model.business_banking.fund_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class FundTransferResponse {
    private String transactionId;
    private String transactionDate;
    private String referenceId;
    private String status;

    public FundTransferResponse(String transactionId, String transactionDate, String referenceId, String status) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.referenceId = referenceId;
        this.status = status;
    }

    public FundTransferResponse() {

    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
