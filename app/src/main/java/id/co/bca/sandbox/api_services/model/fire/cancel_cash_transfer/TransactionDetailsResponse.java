package id.co.bca.sandbox.api_services.model.fire.cancel_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TransactionDetailsResponse {
    private String formNumber;
    private String releaseDateTime;

    public TransactionDetailsResponse(String formNumber, String releaseDateTime) {
        this.formNumber = formNumber;
        this.releaseDateTime = releaseDateTime;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
    }

    public String getReleaseDateTime() {
        return releaseDateTime;
    }

    public void setReleaseDateTime(String releaseDateTime) {
        this.releaseDateTime = releaseDateTime;
    }
}
