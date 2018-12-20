package id.co.bca.sandbox.api_services.model.authentication;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class AccessTokenRequestHeader {
    private String authorization;
    private String contentType;

    public AccessTokenRequestHeader(String authorization, String contentType) {
        this.authorization = authorization;
        this.contentType = contentType;
    }

    public AccessTokenRequestHeader() {

    }

    public String getAuthorization() {
        return this.authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
