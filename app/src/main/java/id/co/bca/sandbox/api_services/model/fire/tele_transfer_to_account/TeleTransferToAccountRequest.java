package id.co.bca.sandbox.api_services.model.fire.tele_transfer_to_account;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class TeleTransferToAccountRequest {
    private AuthenticationRequest authenticationRequest;
    private SenderDetailsRequest senderDetailsRequest;
    private BeneficiaryDetailsRequest beneficiaryDetailsRequest;
    private TransactionDetailsRequest transactionDetailsRequest;

    public TeleTransferToAccountRequest(AuthenticationRequest authenticationRequest, SenderDetailsRequest senderDetailsRequest, BeneficiaryDetailsRequest beneficiaryDetailsRequest, TransactionDetailsRequest transactionDetailsRequest) {
        this.authenticationRequest = authenticationRequest;
        this.senderDetailsRequest = senderDetailsRequest;
        this.beneficiaryDetailsRequest = beneficiaryDetailsRequest;
        this.transactionDetailsRequest = transactionDetailsRequest;
    }

    public AuthenticationRequest getAuthenticationRequest() {
        return authenticationRequest;
    }

    public void setAuthenticationRequest(AuthenticationRequest authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }

    public SenderDetailsRequest getSenderDetailsRequest() {
        return senderDetailsRequest;
    }

    public void setSenderDetailsRequest(SenderDetailsRequest senderDetailsRequest) {
        this.senderDetailsRequest = senderDetailsRequest;
    }

    public BeneficiaryDetailsRequest getBeneficiaryDetailsRequest() {
        return beneficiaryDetailsRequest;
    }

    public void setBeneficiaryDetailsRequest(BeneficiaryDetailsRequest beneficiaryDetailsRequest) {
        this.beneficiaryDetailsRequest = beneficiaryDetailsRequest;
    }

    public TransactionDetailsRequest getTransactionDetailsRequest() {
        return transactionDetailsRequest;
    }

    public void setTransactionDetailsRequest(TransactionDetailsRequest transactionDetailsRequest) {
        this.transactionDetailsRequest = transactionDetailsRequest;
    }
}
