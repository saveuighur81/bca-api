package id.co.bca.sandbox.api_services.utils.networks;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import id.co.bca.sandbox.api_services.model.authentication.AccessTokenPayload;
import id.co.bca.sandbox.api_services.model.authentication.AccessTokenRequest;
import id.co.bca.sandbox.api_services.utils.networks.enums.HTTP_REQUEST_TYPE;

import static id.co.bca.sandbox.api_services.utils.networks.Utils.mapToJson;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class HttpRequest<T> extends Request<T> {
    private Gson gson = new Gson();
    private Class<T> clazz;
    private HTTP_REQUEST_TYPE httpRequestType;
    private Map<String, String> headerCanonical;
    private Map<String, String> bodyCanonical;
    private AccessTokenPayload payloadCanonical;
    private Response.Listener<T> listener;

    public HttpRequest(AccessTokenRequest accessTokenRequest,
                       Class<T> clazz,
                       HTTP_REQUEST_TYPE httpRequestType,
                       Map<String, String> headerCanonical,
                       Map<String, String> bodyCanonical,
                       AccessTokenPayload payloadCanonical,
                       Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {

        super(accessTokenRequest.getHttpMethod(), accessTokenRequest.getHost() + accessTokenRequest.getPath(), errorListener);
        this.clazz = clazz;
        this.httpRequestType = httpRequestType;
        this.headerCanonical = headerCanonical;
        this.bodyCanonical = bodyCanonical;
        this.payloadCanonical = payloadCanonical;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return this.headerCanonical != null ? this.headerCanonical : super.getHeaders();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        try {
            switch (this.httpRequestType) {
                case REQ_ACCESS_TOKEN:
                case REQ_BALANCE_INFO:
                case REQ_ACCOUNT_STATEMENT:
                case REQ_PAYMENT_STATUS:
                    return super.getBody();

                case REQ_FUND_TRANSFER:
                case REQ_DOMESTIC_FUND_TRANSFER:
                case REQ_CREATE_PAYMENT:
                    String strBody = mapToJson(this.bodyCanonical).toString();
                    return strBody == null ? null : strBody.getBytes("UTF-8");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> payloads = new HashMap<>();
        payloads.put("grant_type", this.payloadCanonical.getGrantType());
        return payloads;
    }

    @Override
    protected void deliverResponse(T response) {
        this.listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(this.gson.fromJson(json, this.clazz), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException | JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }
}