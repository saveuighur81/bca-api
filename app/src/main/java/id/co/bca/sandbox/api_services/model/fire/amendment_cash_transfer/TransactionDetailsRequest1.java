package id.co.bca.sandbox.api_services.model.fire.amendment_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TransactionDetailsRequest1 {
    private String formNumber;

    public TransactionDetailsRequest1(String formNumber) {
        this.formNumber = formNumber;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }
}
