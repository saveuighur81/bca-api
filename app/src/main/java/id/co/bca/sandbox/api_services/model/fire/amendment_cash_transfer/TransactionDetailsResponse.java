package id.co.bca.sandbox.api_services.model.fire.amendment_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TransactionDetailsResponse {
    private String description1;
    private String description2;
    private String secretQuestion;
    private String secretAnswer;
    private String formNumber;

    public TransactionDetailsResponse(String description1, String description2, String secretQuestion, String secretAnswer, String formNumber) {
        this.description1 = description1;
        this.description2 = description2;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
        this.formNumber = formNumber;
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

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }
}
