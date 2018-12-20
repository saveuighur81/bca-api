package id.co.bca.sandbox.api_services.model.business_banking.account_statement;

import com.android.volley.VolleyError;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public interface AccountStatementResult {
    void onSuccess(AccountStatementResponse response);

    void onError(VolleyError response);
}
