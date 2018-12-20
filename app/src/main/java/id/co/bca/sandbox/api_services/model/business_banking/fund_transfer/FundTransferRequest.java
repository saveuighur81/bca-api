package id.co.bca.sandbox.api_services.model.business_banking.fund_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class FundTransferRequest {
    private String corporateId;
    private String sourceAccountNumber;
    private String transactionId;
    private String transactionDate;
    private String referenceId;
    private String currencyCode;
    private String amount;
    private String beneficiaryAccountNumber;
    private String remark1;
    private String remark2;

    public FundTransferRequest(String corporateId, String sourceAccountNumber, String transactionId, String transactionDate, String referenceId, String currencyCode, String amount, String beneficiaryAccountNumber, String remark1, String remark2) {
        this.corporateId = corporateId;
        this.sourceAccountNumber = sourceAccountNumber;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.referenceId = referenceId;
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
        this.remark1 = remark1;
        this.remark2 = remark2;
    }

    public FundTransferRequest() {

    }

    public String getCorporateId() {
        return this.corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public String getSourceAccountNumber() {
        return this.sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
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

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBeneficiaryAccountNumber() {
        return this.beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getRemark1() {
        return this.remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}
