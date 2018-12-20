package id.co.bca.sandbox.api_services.model.fire.inquiry_account;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class BeneficiaryDetailsResponse {
    private String serverBeneAccountName;

    public BeneficiaryDetailsResponse(String serverBeneAccountName) {
        this.serverBeneAccountName = serverBeneAccountName;
    }

    public String getServerBeneAccountName() {
        return serverBeneAccountName;
    }

    public void setServerBeneAccountName(String serverBeneAccountName) {
        this.serverBeneAccountName = serverBeneAccountName;
    }
}
