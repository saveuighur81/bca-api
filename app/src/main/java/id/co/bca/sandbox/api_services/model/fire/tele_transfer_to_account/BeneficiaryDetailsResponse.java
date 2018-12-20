package id.co.bca.sandbox.api_services.model.fire.tele_transfer_to_account;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class BeneficiaryDetailsResponse {
    private String name;
    private String accountNumber;
    private String serverBeneAccountName;

    public BeneficiaryDetailsResponse(String name, String accountNumber, String serverBeneAccountName) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.serverBeneAccountName = serverBeneAccountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getServerBeneAccountName() {
        return serverBeneAccountName;
    }

    public void setServerBeneAccountName(String serverBeneAccountName) {
        this.serverBeneAccountName = serverBeneAccountName;
    }
}