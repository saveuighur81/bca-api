package id.co.bca.sandbox.api_services.model.authentication;

import com.android.volley.VolleyError;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public interface AccessTokenResult {
    void onSuccess(AccessTokenResponse response);

    void onError(VolleyError response);
}
