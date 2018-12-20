package id.co.bca.sandbox.api_services.model.business_banking.account_statement;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class AccountStatementRequest {
    private String corporateID;
    private String accountNumber;
    private String startDate;
    private String endDate;

    public AccountStatementRequest(String corporateID, String accountNumber, String startDate, String endDate) {
        this.corporateID = corporateID;
        this.accountNumber = accountNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AccountStatementRequest() {

    }

    public String getCorporateID() {
        return this.corporateID;
    }

    public void setCorporateID(String corporateID) {
        this.corporateID = corporateID;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
