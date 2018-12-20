package id.co.bca.sandbox.api_services.model.business_banking.domestic_fund_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class DomesticFundTransferResponse {
    private String transactionID;
    private String transactionDate;
    private String referenceID;
    private String ppuNumber;

    public DomesticFundTransferResponse(String transactionID, String transactionDate, String referenceID, String ppuNumber) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.referenceID = referenceID;
        this.ppuNumber = ppuNumber;
    }

    public DomesticFundTransferResponse() {

    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }

    public String getPPUNumber() {
        return ppuNumber;
    }

    public void setPPUNumber(String ppuNumber) {
        this.ppuNumber = ppuNumber;
    }
}

