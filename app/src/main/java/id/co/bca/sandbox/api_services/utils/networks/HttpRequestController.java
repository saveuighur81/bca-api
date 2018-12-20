package id.co.bca.sandbox.api_services.utils.networks;

import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static id.co.bca.sandbox.api_services.presenter.BcaApiPresenter.RX_TIMEOUT_MS;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
@SuppressLint("StaticFieldLeak")
public class HttpRequestController {
    private static HttpRequestController instance;
    private static Context context;
    private static RequestQueue requestQueue;

    private HttpRequestController(Context context) {
        try {
            HttpRequestController.context = context;
            requestQueue = Volley.newRequestQueue(context);
            requestQueue.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static synchronized HttpRequestController getInstance(Context context) {
        if (instance == null) {
            instance = new HttpRequestController(context);
        }
        return instance;
    }

    public <T> void addToRequestQueue(Request<T> httpRequest) {
        try {
            httpRequest.setRetryPolicy(new DefaultRetryPolicy(RX_TIMEOUT_MS, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            requestQueue.add(httpRequest);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
