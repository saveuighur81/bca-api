package id.co.bca.sandbox.api_services.model.fire.inquiry_transaction;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryTransactionResponse {
    private SenderDetailsResponse senderDetailsResponse;
    private BeneficiaryDetailsResponse beneficiaryDetailsResponse;
    private TransactionDetailsResponse transactionDetailsResponse;
    private String statusTransaction;
    private String statusMessage;

    public InquiryTransactionResponse(SenderDetailsResponse senderDetailsResponse, BeneficiaryDetailsResponse beneficiaryDetailsResponse, TransactionDetailsResponse transactionDetailsResponse, String statusTransaction, String statusMessage) {
        this.senderDetailsResponse = senderDetailsResponse;
        this.beneficiaryDetailsResponse = beneficiaryDetailsResponse;
        this.transactionDetailsResponse = transactionDetailsResponse;
        this.statusTransaction = statusTransaction;
        this.statusMessage = statusMessage;
    }

    public SenderDetailsResponse getSenderDetailsResponse() {
        return senderDetailsResponse;
    }

    public void setSenderDetailsResponse(SenderDetailsResponse senderDetailsResponse) {
        this.senderDetailsResponse = senderDetailsResponse;
    }

    public BeneficiaryDetailsResponse getBeneficiaryDetailsResponse() {
        return beneficiaryDetailsResponse;
    }

    public void setBeneficiaryDetailsResponse(BeneficiaryDetailsResponse beneficiaryDetailsResponse) {
        this.beneficiaryDetailsResponse = beneficiaryDetailsResponse;
    }

    public TransactionDetailsResponse getTransactionDetailsResponse() {
        return transactionDetailsResponse;
    }

    public void setTransactionDetailsResponse(TransactionDetailsResponse transactionDetailsResponse) {
        this.transactionDetailsResponse = transactionDetailsResponse;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public void setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
