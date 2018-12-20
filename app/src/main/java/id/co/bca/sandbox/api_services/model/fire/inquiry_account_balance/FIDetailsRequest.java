package id.co.bca.sandbox.api_services.model.fire.inquiry_account_balance;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class FIDetailsRequest {
    private String accountNumber;

    public FIDetailsRequest(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
