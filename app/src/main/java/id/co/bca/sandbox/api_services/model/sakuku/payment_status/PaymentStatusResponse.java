package id.co.bca.sandbox.api_services.model.sakuku.payment_status;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class PaymentStatusResponse {
    private String paymentID;
    private String amount;
    private String requestDate;
    private String paymentStatus;
    private ReasonStatus reasonStatus;

    public PaymentStatusResponse(String paymentID, String amount, String requestDate, String paymentStatus, ReasonStatus reasonStatus) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.requestDate = requestDate;
        this.paymentStatus = paymentStatus;
        this.reasonStatus = reasonStatus;
    }

    public PaymentStatusResponse() {

    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ReasonStatus getReasonStatus() {
        return reasonStatus;
    }

    public void setReasonStatus(ReasonStatus reasonStatus) {
        this.reasonStatus = reasonStatus;
    }
}