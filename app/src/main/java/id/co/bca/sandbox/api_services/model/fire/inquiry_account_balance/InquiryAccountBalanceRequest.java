package id.co.bca.sandbox.api_services.model.fire.inquiry_account_balance;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class InquiryAccountBalanceRequest {
    private AuthenticationRequest authenticationRequest;
    private FIDetailsRequest fiDetailsRequest;

    public InquiryAccountBalanceRequest(AuthenticationRequest authenticationRequest, FIDetailsRequest fiDetailsRequest) {
        this.authenticationRequest = authenticationRequest;
        this.fiDetailsRequest = fiDetailsRequest;
    }

    public AuthenticationRequest getAuthenticationRequest() {
        return authenticationRequest;
    }

    public void setAuthenticationRequest(AuthenticationRequest authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }

    public FIDetailsRequest getFiDetailsRequest() {
        return fiDetailsRequest;
    }

    public void setFiDetailsRequest(FIDetailsRequest fiDetailsRequest) {
        this.fiDetailsRequest = fiDetailsRequest;
    }
}
