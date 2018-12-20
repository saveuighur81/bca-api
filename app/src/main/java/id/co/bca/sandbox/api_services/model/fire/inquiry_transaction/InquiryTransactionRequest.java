package id.co.bca.sandbox.api_services.model.fire.inquiry_transaction;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryTransactionRequest {
    private AuthenticationRequest authenticationRequest;
    private TransactionDetailsRequest transactionDetailsRequest;

    public InquiryTransactionRequest(AuthenticationRequest authenticationRequest, TransactionDetailsRequest transactionDetailsRequest) {
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
