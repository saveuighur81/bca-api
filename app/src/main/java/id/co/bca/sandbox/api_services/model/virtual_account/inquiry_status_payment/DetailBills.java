package id.co.bca.sandbox.api_services.model.virtual_account.inquiry_status_payment;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class DetailBills {
    private String billReference;
    private String billNumber;

    public DetailBills(String billReference, String billNumber) {
        this.billReference = billReference;
        this.billNumber = billNumber;
    }

    public String getBillReference() {
        return billReference;
    }

    public void setBillReference(String billReference) {
        this.billReference = billReference;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }
}
