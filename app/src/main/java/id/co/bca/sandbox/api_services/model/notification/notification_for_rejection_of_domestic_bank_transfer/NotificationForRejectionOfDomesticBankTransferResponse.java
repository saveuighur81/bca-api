package id.co.bca.sandbox.api_services.model.notification.notification_for_rejection_of_domestic_bank_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class NotificationForRejectionOfDomesticBankTransferResponse {
    private String responseWS;

    public NotificationForRejectionOfDomesticBankTransferResponse(String responseWS) {
        this.responseWS = responseWS;
    }

    public String getResponseWS() {
        return responseWS;
    }

    public void setResponseWS(String responseWS) {
        this.responseWS = responseWS;
    }
}
