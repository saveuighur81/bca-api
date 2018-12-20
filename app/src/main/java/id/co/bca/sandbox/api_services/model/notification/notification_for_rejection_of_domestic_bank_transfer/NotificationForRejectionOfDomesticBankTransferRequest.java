package id.co.bca.sandbox.api_services.model.notification.notification_for_rejection_of_domestic_bank_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class NotificationForRejectionOfDomesticBankTransferRequest {
    private String transactionID;
    private String transactionDate;
    private String transferType;
    private String PPUNumber;
    private String accountNoFrom;
    private String accountNoTo;
    private String receiverBankCode;
    private String receiverName;
    private String amount;
    private String rejectStatusID;
    private String rejectStatusEN;

    public NotificationForRejectionOfDomesticBankTransferRequest(String transactionID, String transactionDate, String transferType, String PPUNumber, String accountNoFrom, String accountNoTo, String receiverBankCode, String receiverName, String amount, String rejectStatusID, String rejectStatusEN) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.transferType = transferType;
        this.PPUNumber = PPUNumber;
        this.accountNoFrom = accountNoFrom;
        this.accountNoTo = accountNoTo;
        this.receiverBankCode = receiverBankCode;
        this.receiverName = receiverName;
        this.amount = amount;
        this.rejectStatusID = rejectStatusID;
        this.rejectStatusEN = rejectStatusEN;
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

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getPPUNumber() {
        return PPUNumber;
    }

    public void setPPUNumber(String PPUNumber) {
        this.PPUNumber = PPUNumber;
    }

    public String getAccountNoFrom() {
        return accountNoFrom;
    }

    public void setAccountNoFrom(String accountNoFrom) {
        this.accountNoFrom = accountNoFrom;
    }

    public String getAccountNoTo() {
        return accountNoTo;
    }

    public void setAccountNoTo(String accountNoTo) {
        this.accountNoTo = accountNoTo;
    }

    public String getReceiverBankCode() {
        return receiverBankCode;
    }

    public void setReceiverBankCode(String receiverBankCode) {
        this.receiverBankCode = receiverBankCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRejectStatusID() {
        return rejectStatusID;
    }

    public void setRejectStatusID(String rejectStatusID) {
        this.rejectStatusID = rejectStatusID;
    }

    public String getRejectStatusEN() {
        return rejectStatusEN;
    }

    public void setRejectStatusEN(String rejectStatusEN) {
        this.rejectStatusEN = rejectStatusEN;
    }
}
