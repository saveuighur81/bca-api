package id.co.bca.sandbox.api_services.model.fire.inquiry_account_balance;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryAccountBalanceResponse {
    private FIDetailsResponse fiDetailsResponse;
    private String statusTransaction;
    private String statusMessage;

    public InquiryAccountBalanceResponse(FIDetailsResponse fiDetailsResponse, String statusTransaction, String statusMessage) {
        this.fiDetailsResponse = fiDetailsResponse;
        this.statusTransaction = statusTransaction;
        this.statusMessage = statusMessage;
    }

    public FIDetailsResponse getFiDetailsResponse() {
        return fiDetailsResponse;
    }

    public void setFiDetailsResponse(FIDetailsResponse fiDetailsResponse) {
        this.fiDetailsResponse = fiDetailsResponse;
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
