package id.co.bca.sandbox.api_services.model.fire.inquiry_transaction;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TransactionDetailsResponse {
    private String amountPaid;
    private String currencyID;
    private String releaseDateTime;
    private String localID;
    private String formNumber;
    private String referenceNumber;
    private String PIN;
    private String description1;
    private String description2;

    public TransactionDetailsResponse(String amountPaid, String currencyID, String releaseDateTime, String localID, String formNumber, String referenceNumber, String PIN, String description1, String description2) {
        this.amountPaid = amountPaid;
        this.currencyID = currencyID;
        this.releaseDateTime = releaseDateTime;
        this.localID = localID;
        this.formNumber = formNumber;
        this.referenceNumber = referenceNumber;
        this.PIN = PIN;
        this.description1 = description1;
        this.description2 = description2;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public String getReleaseDateTime() {
        return releaseDateTime;
    }

    public void setReleaseDateTime(String releaseDateTime) {
        this.releaseDateTime = releaseDateTime;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
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

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
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
}
