package id.co.bca.sandbox.api_services.model.virtual_account.inquiry_status_payment;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryStatusPaymentByCustomerNumberRequest {
    private String companyCode;
    private String customerNumber;

    public InquiryStatusPaymentByCustomerNumberRequest(String companyCode, String customerNumber) {
        this.companyCode = companyCode;
        this.customerNumber = customerNumber;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
