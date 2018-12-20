package id.co.bca.sandbox.api_services.model.notification.notification_for_securities;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class NotificationForSecuritiesRequest {
    private String externalReference;
    private String seqNumber;
    private String accountNumber;
    private String currency;
    private String txnDate;
    private String txnType;
    private String txnCode;
    private String accountDebit;
    private String accountCredit;
    private String txnAmount;
    private String openBalance;
    private String closeBalance;
    private String txnDesc;

    public NotificationForSecuritiesRequest(String externalReference, String seqNumber, String accountNumber, String currency, String txnDate, String txnType, String txnCode, String accountDebit, String accountCredit, String txnAmount, String openBalance, String closeBalance, String txnDesc) {
        this.externalReference = externalReference;
        this.seqNumber = seqNumber;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.txnDate = txnDate;
        this.txnType = txnType;
        this.txnCode = txnCode;
        this.accountDebit = accountDebit;
        this.accountCredit = accountCredit;
        this.txnAmount = txnAmount;
        this.openBalance = openBalance;
        this.closeBalance = closeBalance;
        this.txnDesc = txnDesc;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        this.seqNumber = seqNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnCode() {
        return txnCode;
    }

    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode;
    }

    public String getAccountDebit() {
        return accountDebit;
    }

    public void setAccountDebit(String accountDebit) {
        this.accountDebit = accountDebit;
    }

    public String getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(String accountCredit) {
        this.accountCredit = accountCredit;
    }

    public String getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(String txnAmount) {
        this.txnAmount = txnAmount;
    }

    public String getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(String openBalance) {
        this.openBalance = openBalance;
    }

    public String getCloseBalance() {
        return closeBalance;
    }

    public void setCloseBalance(String closeBalance) {
        this.closeBalance = closeBalance;
    }

    public String getTxnDesc() {
        return txnDesc;
    }

    public void setTxnDesc(String txnDesc) {
        this.txnDesc = txnDesc;
    }
}
