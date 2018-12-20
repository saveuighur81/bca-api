package id.co.bca.sandbox.api_services.model.fire.tele_transfer_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TransactionDetailsRequest {
    private String PIN;
    private String secretQuestion;
    private String secretAnswer;
    private String currencyID;
    private String amount;
    private String purposeCode;
    private String description1;
    private String description2;
    private String detailOfCharges;
    private String sourceOfFund;
    private String formNumber;

    public TransactionDetailsRequest(String PIN, String secretQuestion, String secretAnswer, String currencyID, String amount, String purposeCode, String description1, String description2, String detailOfCharges, String sourceOfFund, String formNumber) {
        this.PIN = PIN;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
        this.currencyID = currencyID;
        this.amount = amount;
        this.purposeCode = purposeCode;
        this.description1 = description1;
        this.description2 = description2;
        this.detailOfCharges = detailOfCharges;
        this.sourceOfFund = sourceOfFund;
        this.formNumber = formNumber;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
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

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
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

    public String getDetailOfCharges() {
        return detailOfCharges;
    }

    public void setDetailOfCharges(String detailOfCharges) {
        this.detailOfCharges = detailOfCharges;
    }

    public String getSourceOfFund() {
        return sourceOfFund;
    }

    public void setSourceOfFund(String sourceOfFund) {
        this.sourceOfFund = sourceOfFund;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }
}
