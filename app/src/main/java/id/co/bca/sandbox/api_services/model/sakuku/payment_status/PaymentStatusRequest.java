package id.co.bca.sandbox.api_services.model.sakuku.payment_status;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class PaymentStatusRequest {
    private String merchantID;
    private String paymentID;

    public PaymentStatusRequest(String merchantID, String paymentID) {
        this.merchantID = merchantID;
        this.paymentID = paymentID;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }
}

