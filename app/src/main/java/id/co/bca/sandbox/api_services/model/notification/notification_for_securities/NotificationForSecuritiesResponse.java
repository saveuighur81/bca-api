package id.co.bca.sandbox.api_services.model.notification.notification_for_securities;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class NotificationForSecuritiesResponse {
    private String responseWS;

    public NotificationForSecuritiesResponse(String responseWS) {
        this.responseWS = responseWS;
    }

    public String getResponseWS() {
        return responseWS;
    }

    public void setResponseWS(String responseWS) {
        this.responseWS = responseWS;
    }
}
