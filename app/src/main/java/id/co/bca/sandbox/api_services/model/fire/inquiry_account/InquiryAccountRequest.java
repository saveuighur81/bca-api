package id.co.bca.sandbox.api_services.model.fire.inquiry_account;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryAccountRequest {
    private AuthenticationRequest authenticationRequest;
    private BeneficiaryDetailsRequest beneficiaryDetailsRequest;

    public InquiryAccountRequest(AuthenticationRequest authenticationRequest, BeneficiaryDetailsRequest beneficiaryDetailsRequest) {
        this.authenticationRequest = authenticationRequest;
        this.beneficiaryDetailsRequest = beneficiaryDetailsRequest;
    }

    public AuthenticationRequest getAuthenticationRequest() {
        return authenticationRequest;
    }

    public void setAuthenticationRequest(AuthenticationRequest authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }

    public BeneficiaryDetailsRequest getBeneficiaryDetailsRequest() {
        return beneficiaryDetailsRequest;
    }

    public void setBeneficiaryDetailsRequest(BeneficiaryDetailsRequest beneficiaryDetailsRequest) {
        this.beneficiaryDetailsRequest = beneficiaryDetailsRequest;
    }
}
