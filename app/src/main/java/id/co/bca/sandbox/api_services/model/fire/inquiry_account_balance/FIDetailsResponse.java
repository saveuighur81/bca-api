package id.co.bca.sandbox.api_services.model.fire.inquiry_account_balance;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class FIDetailsResponse {
    private String currencyID;
    private String accountBalance;

    public FIDetailsResponse(String currencyID, String accountBalance) {
        this.currencyID = currencyID;
        this.accountBalance = accountBalance;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
}
