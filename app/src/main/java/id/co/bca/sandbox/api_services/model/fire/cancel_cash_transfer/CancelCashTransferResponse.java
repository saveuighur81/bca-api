package id.co.bca.sandbox.api_services.model.fire.cancel_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class CancelCashTransferResponse {
    private TransactionDetailsResponse transactionDetailsResponse;
    private String statusTransaction;
    private String statusMessage;

    public CancelCashTransferResponse(TransactionDetailsResponse transactionDetailsResponse, String statusTransaction, String statusMessage) {
        this.transactionDetailsResponse = transactionDetailsResponse;
        this.statusTransaction = statusTransaction;
        this.statusMessage = statusMessage;
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
