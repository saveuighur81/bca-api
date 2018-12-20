package id.co.bca.sandbox.api_services.model.business_banking.domestic_fund_transfer;

import com.android.volley.VolleyError;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public interface DomesticFundTransferResult {
    void onSuccess(DomesticFundTransferResponse response);

    void onError(VolleyError response);
}
