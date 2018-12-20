package id.co.bca.sandbox.api_services.model.sakuku.create_payment;

import com.android.volley.VolleyError;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public interface CreatePaymentResult {
    void onSuccess(CreatePaymentResponse response);

    void onError(VolleyError response);
}
