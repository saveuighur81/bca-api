package id.co.bca.sandbox.api_services.model.fire.amendment_cash_transfer;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class AmendmentDetailsRequest {
    private SenderDetailsRequest senderDetailsRequest;
    private BeneficiaryDetailsRequest beneficiaryDetailsRequest;
    private TransactionDetailsRequest transactionDetailsRequest;

    public AmendmentDetailsRequest(SenderDetailsRequest senderDetailsRequest, BeneficiaryDetailsRequest beneficiaryDetailsRequest, TransactionDetailsRequest transactionDetailsRequest) {
        this.senderDetailsRequest = senderDetailsRequest;
        this.beneficiaryDetailsRequest = beneficiaryDetailsRequest;
        this.transactionDetailsRequest = transactionDetailsRequest;
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
