package id.co.bca.sandbox.api_services.model.business_banking.account_statement;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class Data {
    private String transactionDate;
    private String branchCode;
    private String transactionType;
    private String transactionAmount;
    private String transactionName;
    private String trailer;

    public Data(String transactionDate, String branchCode, String transactionType, String transactionAmount, String transactionName, String trailer) {
        this.transactionDate = transactionDate;
        this.branchCode = branchCode;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionName = transactionName;
        this.trailer = trailer;
    }

    public Data() {

    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getBranchCode() {
        return this.branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionName() {
        return this.transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
