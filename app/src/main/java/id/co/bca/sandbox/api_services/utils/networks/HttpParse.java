package id.co.bca.sandbox.api_services.utils.networks;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class HttpParse {

    public static String parseVolleyError(String senderName, VolleyError error) {
        try {
            String errorCode;
            String errorMessage;

            NetworkResponse networkResponse = error.networkResponse;
            if (networkResponse != null && networkResponse.data != null) {
                JsonParser parser = new JsonParser();

                JsonObject rootObject = parser.parse(new String(error.networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers))).getAsJsonObject();
                if (rootObject != null) {
                    errorCode = rootObject.get("ErrorCode").getAsString();
                    errorMessage = rootObject.get("ErrorMessage").getAsJsonObject().get("Indonesian").getAsString();
                    return (senderName + " - Error: " + errorCode + " - " + errorMessage);
                }
            } else {
                return (senderName + " - " + error.getLocalizedMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static JsonArray parseBalanceSuccessInfo(JsonObject values) {
        try {
            JsonParser parser = new JsonParser();
            JsonObject rootObject = parser.parse(values.toString()).getAsJsonObject();

            if (rootObject != null) {
                JsonArray successArray = rootObject.get("AccountDetailDataSuccess").getAsJsonArray();
                if (successArray != null && successArray.size() > 0) {
                    return successArray;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static JsonArray parseBalanceFailedInfo(JsonObject values) {
        try {
            JsonParser parser = new JsonParser();
            JsonObject rootObject = parser.parse(values.toString()).getAsJsonObject();

            if (rootObject != null) {
                JsonArray failedArray = rootObject.get("AccountDetailDataFailed").getAsJsonArray();
                if (failedArray != null && failedArray.size() > 0) {
                    return failedArray;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static JsonObject parseAccountStatementList(JsonObject values) {
        try {
            JsonParser parser = new JsonParser();
            JsonObject rootObject = parser.parse(values.toString()).getAsJsonObject();

            if (rootObject != null) {
                return rootObject;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static JsonArray parseAccountStatementItem(JsonObject values) {
        try {
            JsonParser parser = new JsonParser();

            JsonObject rootObject = parser.parse(values.toString()).getAsJsonObject();
            if (rootObject != null) {
                JsonArray dataArray = rootObject.get("Data").getAsJsonArray();
                if (dataArray != null && dataArray.size() > 0) {
                    return dataArray;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
