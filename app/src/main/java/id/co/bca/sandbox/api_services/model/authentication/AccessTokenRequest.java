package id.co.bca.sandbox.api_services.model.authentication;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class AccessTokenRequest {
    private int httpMethod;
    private String path;
    private String host;

    public AccessTokenRequest(int httpMethod, String path, String host) {
        this.httpMethod = httpMethod;
        this.path = path;
        this.host = host;
    }

    public AccessTokenRequest() {

    }

    public int getHttpMethod() {
        return this.httpMethod;
    }

    public void setHttpMethod(int httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
