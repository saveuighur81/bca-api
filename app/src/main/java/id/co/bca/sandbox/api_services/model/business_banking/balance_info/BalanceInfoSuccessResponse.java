package id.co.bca.sandbox.api_services.model.business_banking.balance_info;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class BalanceInfoSuccessResponse {
    private String accountNumber;
    private String currency;
    private String balance;
    private String availableBalance;
    private String floatAmount;
    private String holdAmount;
    private String plafon;

    public BalanceInfoSuccessResponse(String accountNumber, String currency, String balance, String availableBalance, String floatAmount, String holdAmount, String plafon) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
        this.availableBalance = availableBalance;
        this.floatAmount = floatAmount;
        this.holdAmount = holdAmount;
        this.plafon = plafon;
    }

    public BalanceInfoSuccessResponse() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getFloatAmount() {
        return floatAmount;
    }

    public void setFloatAmount(String floatAmount) {
        this.floatAmount = floatAmount;
    }

    public String getHoldAmount() {
        return holdAmount;
    }

    public void setHoldAmount(String holdAmount) {
        this.holdAmount = holdAmount;
    }

    public String getPlafon() {
        return plafon;
    }

    public void setPlafon(String plafon) {
        this.plafon = plafon;
    }
}
