package id.co.bca.sandbox.api_services.model.business_banking.domestic_fund_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class DomesticFundTransferRequest {
    private String transactionID;
    private String transactionDate;
    private String referenceID;
    private String sourceAccountNumber;
    private String beneficiaryAccountNumber;
    private String beneficiaryBankCode;
    private String beneficiaryName;
    private String amount;
    private String transferType;
    private String beneficiaryCustType;
    private String beneficiaryCustResidence;
    private String currencyCode;
    private String remark1;
    private String remark2;
    private String channelID;
    private String credentialID;

    public DomesticFundTransferRequest(String transactionID, String transactionDate, String referenceID, String sourceAccountNumber, String beneficiaryAccountNumber, String beneficiaryBankCode, String beneficiaryName, String amount, String transferType, String beneficiaryCustType, String beneficiaryCustResidence, String currencyCode, String remark1, String remark2, String channelID, String credentialID) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.referenceID = referenceID;
        this.sourceAccountNumber = sourceAccountNumber;
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
        this.beneficiaryBankCode = beneficiaryBankCode;
        this.beneficiaryName = beneficiaryName;
        this.amount = amount;
        this.transferType = transferType;
        this.beneficiaryCustType = beneficiaryCustType;
        this.beneficiaryCustResidence = beneficiaryCustResidence;
        this.currencyCode = currencyCode;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.channelID = channelID;
        this.credentialID = credentialID;
    }

    public DomesticFundTransferRequest() {

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

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getBeneficiaryBankCode() {
        return beneficiaryBankCode;
    }

    public void setBeneficiaryBankCode(String beneficiaryBankCode) {
        this.beneficiaryBankCode = beneficiaryBankCode;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getBeneficiaryCustType() {
        return beneficiaryCustType;
    }

    public void setBeneficiaryCustType(String beneficiaryCustType) {
        this.beneficiaryCustType = beneficiaryCustType;
    }

    public String getBeneficiaryCustResidence() {
        return beneficiaryCustResidence;
    }

    public void setBeneficiaryCustResidence(String beneficiaryCustResidence) {
        this.beneficiaryCustResidence = beneficiaryCustResidence;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getCredentialID() {
        return credentialID;
    }

    public void setCredentialID(String credentialID) {
        this.credentialID = credentialID;
    }
}

