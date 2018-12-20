package id.co.bca.sandbox.api_services.model.fire.inquiry_transaction;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TransactionDetailsRequest {
    private String inquiryBy;
    private String inquiryValue;

    public TransactionDetailsRequest(String inquiryBy, String inquiryValue) {
        this.inquiryBy = inquiryBy;
        this.inquiryValue = inquiryValue;
    }

    public String getInquiryBy() {
        return inquiryBy;
    }

    public void setInquiryBy(String inquiryBy) {
        this.inquiryBy = inquiryBy;
    }

    public String getInquiryValue() {
        return inquiryValue;
    }

    public void setInquiryValue(String inquiryValue) {
        this.inquiryValue = inquiryValue;
    }
}
