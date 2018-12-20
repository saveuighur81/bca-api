package id.co.bca.sandbox.api_services.model.authentication;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class AccessTokenPayload {
    private String grantType;

    public AccessTokenPayload(String grantType) {
        this.grantType = grantType;
    }

    public AccessTokenPayload() {

    }

    public String getGrantType() {
        return this.grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
