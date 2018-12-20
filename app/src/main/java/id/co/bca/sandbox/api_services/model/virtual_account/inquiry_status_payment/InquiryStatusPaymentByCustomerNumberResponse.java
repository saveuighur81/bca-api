package id.co.bca.sandbox.api_services.model.virtual_account.inquiry_status_payment;

import java.util.List;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryStatusPaymentByCustomerNumberResponse {
    private List<DetailBills> detailBillList;
    private String requestID;
    private String transactionDate;
    private String paymentFlagStatus;
    private String reference;
    private String totalAmount;
    private String paidAmount;

    public InquiryStatusPaymentByCustomerNumberResponse(List<DetailBills> detailBillList, String requestID, String transactionDate, String paymentFlagStatus, String reference, String totalAmount, String paidAmount) {
        this.detailBillList = detailBillList;
        this.requestID = requestID;
        this.transactionDate = transactionDate;
        this.paymentFlagStatus = paymentFlagStatus;
        this.reference = reference;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
    }

    public List<DetailBills> getDetailBillList() {
        return detailBillList;
    }

    public void setDetailBillList(List<DetailBills> detailBillList) {
        this.detailBillList = detailBillList;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getPaymentFlagStatus() {
        return paymentFlagStatus;
    }

    public void setPaymentFlagStatus(String paymentFlagStatus) {
        this.paymentFlagStatus = paymentFlagStatus;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }
}
