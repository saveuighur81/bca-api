package id.co.bca.sandbox.api_services.model.sakuku.payment_status;

import com.android.volley.VolleyError;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public interface PaymentStatusResult {
    void onSuccess(PaymentStatusResponse response);

    void onError(VolleyError response);
}
