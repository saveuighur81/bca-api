package id.co.bca.sandbox.api_services.model.fire.tele_transfer_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TransactionDetailsResponse {
    private String PIN;
    private String currencyID;
    private String amount;
    private String description1;
    private String description2;
    private String formNumber;
    private String referenceNumber;
    private String releaseDateTime;

    public TransactionDetailsResponse(String PIN, String currencyID, String amount, String description1, String description2, String formNumber, String referenceNumber, String releaseDateTime) {
        this.PIN = PIN;
        this.currencyID = currencyID;
        this.amount = amount;
        this.description1 = description1;
        this.description2 = description2;
        this.formNumber = formNumber;
        this.referenceNumber = referenceNumber;
        this.releaseDateTime = releaseDateTime;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReleaseDateTime() {
        return releaseDateTime;
    }

    public void setReleaseDateTime(String releaseDateTime) {
        this.releaseDateTime = releaseDateTime;
    }
}
