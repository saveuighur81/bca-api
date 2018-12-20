package id.co.bca.sandbox.api_services.model.fire.cancel_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class CancelCashTransferRequest {
    private AuthenticationRequest authenticationRequest;
    private TransactionDetailsRequest transactionDetailsRequest;

    public CancelCashTransferRequest(AuthenticationRequest authenticationRequest, TransactionDetailsRequest transactionDetailsRequest) {
        this.authenticationRequest = authenticationRequest;
        this.transactionDetailsRequest = transactionDetailsRequest;
    }

    public AuthenticationRequest getAuthenticationRequest() {
        return authenticationRequest;
    }

    public void setAuthenticationRequest(AuthenticationRequest authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }

    public TransactionDetailsRequest getTransactionDetailsRequest() {
        return transactionDetailsRequest;
    }

    public void setTransactionDetailsRequest(TransactionDetailsRequest transactionDetailsRequest) {
        this.transactionDetailsRequest = transactionDetailsRequest;
    }
}
