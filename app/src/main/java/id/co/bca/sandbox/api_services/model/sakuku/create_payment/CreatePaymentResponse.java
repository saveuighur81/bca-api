package id.co.bca.sandbox.api_services.model.sakuku.create_payment;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class CreatePaymentResponse {
    private String transactionID;
    private String paymentID;
    private String landingPageURL;

    public CreatePaymentResponse(String transactionID, String paymentID, String landingPageURL) {
        this.transactionID = transactionID;
        this.paymentID = paymentID;
        this.landingPageURL = landingPageURL;
    }

    public CreatePaymentResponse() {

    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getLandingPageURL() {
        return landingPageURL;
    }

    public void setLandingPageURL(String landingPageURL) {
        this.landingPageURL = landingPageURL;
    }
}