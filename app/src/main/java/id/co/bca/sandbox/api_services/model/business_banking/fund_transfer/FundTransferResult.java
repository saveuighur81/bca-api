package id.co.bca.sandbox.api_services.model.business_banking.fund_transfer;

import com.android.volley.VolleyError;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public interface FundTransferResult {
    void onSuccess(FundTransferResponse response);

    void onError(VolleyError response);
}
