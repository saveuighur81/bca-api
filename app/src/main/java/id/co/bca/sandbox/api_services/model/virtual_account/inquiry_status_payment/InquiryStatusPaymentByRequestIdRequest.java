package id.co.bca.sandbox.api_services.model.virtual_account.inquiry_status_payment;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryStatusPaymentByRequestIdRequest {
    private String companyCode;
    private String requestID;

    public InquiryStatusPaymentByRequestIdRequest(String companyCode, String requestID) {
        this.companyCode = companyCode;
        this.requestID = requestID;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }
}
