package id.co.bca.sandbox.api_services.model.fire.cancel_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TransactionDetailsRequest {
    private String formNumber;
    private String amount;
    private String currencyID;

    public TransactionDetailsRequest(String formNumber, String amount, String currencyID) {
        this.formNumber = formNumber;
        this.amount = amount;
        this.currencyID = currencyID;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }
}
