package id.co.bca.sandbox.api_services.model.fire.inquiry_account;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryAccountResponse {
    private BeneficiaryDetailsResponse beneficiaryDetailsResponse;
    private String statusTransaction;
    private String statusMessage;

    public InquiryAccountResponse(BeneficiaryDetailsResponse beneficiaryDetailsResponse, String statusTransaction, String statusMessage) {
        this.beneficiaryDetailsResponse = beneficiaryDetailsResponse;
        this.statusTransaction = statusTransaction;
        this.statusMessage = statusMessage;
    }

    public BeneficiaryDetailsResponse getBeneficiaryDetailsResponse() {
        return beneficiaryDetailsResponse;
    }

    public void setBeneficiaryDetailsResponse(BeneficiaryDetailsResponse beneficiaryDetailsResponse) {
        this.beneficiaryDetailsResponse = beneficiaryDetailsResponse;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public void setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}

