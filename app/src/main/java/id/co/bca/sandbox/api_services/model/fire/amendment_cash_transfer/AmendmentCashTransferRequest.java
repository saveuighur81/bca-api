package id.co.bca.sandbox.api_services.model.fire.amendment_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class AmendmentCashTransferRequest {
    private AuthenticationRequest authenticationRequest;
    private AmendmentDetailsRequest amendmentDetailsRequest;
    private TransactionDetailsRequest1 transactionDetailsRequest1;

    public AmendmentCashTransferRequest(AuthenticationRequest authenticationRequest, AmendmentDetailsRequest amendmentDetailsRequest, TransactionDetailsRequest1 transactionDetailsRequest1) {
        this.authenticationRequest = authenticationRequest;
        this.amendmentDetailsRequest = amendmentDetailsRequest;
        this.transactionDetailsRequest1 = transactionDetailsRequest1;
    }

    public AuthenticationRequest getAuthenticationRequest() {
        return authenticationRequest;
    }

    public void setAuthenticationRequest(AuthenticationRequest authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }

    public AmendmentDetailsRequest getAmendmentDetailsRequest() {
        return amendmentDetailsRequest;
    }

    public void setAmendmentDetailsRequest(AmendmentDetailsRequest amendmentDetailsRequest) {
        this.amendmentDetailsRequest = amendmentDetailsRequest;
    }

    public TransactionDetailsRequest1 getTransactionDetailsRequest1() {
        return transactionDetailsRequest1;
    }

    public void setTransactionDetailsRequest1(TransactionDetailsRequest1 transactionDetailsRequest1) {
        this.transactionDetailsRequest1 = transactionDetailsRequest1;
    }
}
