package id.co.bca.sandbox.api_services.model.business_banking.balance_info;

import com.android.volley.VolleyError;

import java.util.List;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public interface BalanceInfoResult {
    void onSuccess(List<BalanceInfoSuccessResponse> response);

    void onFailed(List<BalanceInfoFailedResponse> response);

    void onError(VolleyError response);
}
