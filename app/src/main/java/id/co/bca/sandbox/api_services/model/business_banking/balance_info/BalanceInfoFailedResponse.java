package id.co.bca.sandbox.api_services.model.business_banking.balance_info;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class BalanceInfoFailedResponse {
    private String english;
    private String indonesian;
    private String accountNumber;

    public BalanceInfoFailedResponse(String english, String indonesian, String accountNumber) {
        this.english = english;
        this.indonesian = indonesian;
        this.accountNumber = accountNumber;
    }

    public BalanceInfoFailedResponse() {

    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getIndonesian() {
        return indonesian;
    }

    public void setIndonesian(String indonesian) {
        this.indonesian = indonesian;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
