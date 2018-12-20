package id.co.bca.sandbox.api_services.utils.networks;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import id.co.bca.sandbox.api_services.utils.networks.enums.SORT_TYPE;

import static id.co.bca.sandbox.api_services.Keys.SECRET_KEY;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class Utils {

    private static String toHexUtf8(char value) {
        try {
            byte[] b = String.valueOf(value).getBytes("UTF-8");
            for (int i = 0; i < b.length; i++) {
                int j = b[i];
                if (j < 0) {
                    j += 256;
                }
                return "%" + Integer.toHexString(j).toUpperCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String urlEncode(@NonNull CharSequence value, boolean encodeSlash) {
        try {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                if ((ch >= 0x41 && ch <= 0x5A) ||
                        (ch >= 0x61 && ch <= 0x7A) ||
                        (ch >= 0x30 && ch <= 0x39) ||
                        (ch == 0x5F || ch == 0x2D || ch == 0x7E || ch == 0x2E)) {
                    result.append(ch);
                } else if (ch == 0x2F) {
                    result.append(encodeSlash ? "%2F" : ch);
                } else {
                    result.append(toHexUtf8(ch));
                }
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String stripWhitespace(@NonNull String value) {
        try {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                if ((ch >= 0x09 && ch <= 0x0D) || ch == 0x20) {
                    continue;
                }
                result.append(ch);
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytesToHex(@NonNull byte[] values) {
        try {
            StringBuilder sb = new StringBuilder();
            for (byte b : values) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String calSha256(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytesEncoded = digest.digest(value.getBytes("UTF-8"));
            return bytesToHex(bytesEncoded);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String calHmacSha256(String value, @NonNull String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] bytesEncoded = mac.doFinal(value.getBytes("UTF-8"));
            return bytesToHex(bytesEncoded);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String urlCanonicalization(@NonNull String value) {
        String relativeUrlCanonical = value;
        try {
            String queryStringCanonical = "";
            int index = value.indexOf("?");
            if (index != -1) {
                relativeUrlCanonical = value.substring(0, index);
                queryStringCanonical = value.substring(index + 1);
            }

            if (!relativeUrlCanonical.startsWith("/")) {
                relativeUrlCanonical = "/" + relativeUrlCanonical;
            }
            relativeUrlCanonical = urlEncode(relativeUrlCanonical, false);

            String[] queryArray = queryStringCanonical.split("&");
            for (int i = 0; i < queryArray.length; i++) {
                String item = queryArray[i];
                if (item == null || item.trim().equals("")) {
                    continue;
                }
                String key = item.split("=")[0];
                String val = item.split("=")[1];
                key = urlEncode(key, true);
                val = urlEncode(val, true);
                queryArray[i] = key + "=" + val;
            }

            Arrays.sort(queryArray);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < queryArray.length; i++) {
                String item = queryArray[i];
                if (item == null || item.trim().equals("")) {
                    continue;
                }
                sb.append(item);
                sb.append("&");
            }

            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            queryStringCanonical = sb.toString();

            if (index != -1) {
                return relativeUrlCanonical + "?" + queryStringCanonical;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return relativeUrlCanonical;
    }

    public static Map<String, String> headerCanonicalization(@NonNull Map<String, String> value) {
        try {
            return shortMap(value, SORT_TYPE.ASCENDING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, String> bodyCanonicalization(@NonNull Map<String, String> value) {
        try {
            Map<String, String> map = shortMap(value, SORT_TYPE.ASCENDING);
            if (map != null) {
                String strJson = mapToJson(map).toString();
                String stripWs = stripWhitespace(strJson);
                JsonObject json = strToJson(stripWs);
                if (json != null) {
                    return jsonToMap(json);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String hashBodyCanonicalization(Map<String, String> value) {
        try {
            if (value == null) {
                return calSha256("");

            } else if (value.size() > 0) {
                Map<String, String> map = shortMap(value, SORT_TYPE.ASCENDING);
                if (map != null) {
                    String strJson = mapToJson(map).toString();
                    String stripWs = stripWhitespace(strJson);
                    return calSha256(stripWs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCurrrentDate() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));
            return dateFormat.format(new Date());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Map<String, String> jsonToMap(@NonNull JsonObject values) {
        try {
            return new Gson().fromJson(values, new TypeToken<Map<String, String>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JsonObject mapToJson(@NonNull Map<String, String> values) {
        try {
            return new Gson().toJsonTree(values).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Gson().toJsonTree(null).getAsJsonObject();
    }

    public static JsonObject strToJson(@NonNull String values) {
        try {
            return new JsonParser().parse(values).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonParser().parse("").getAsJsonObject();
    }

    public static Map<String, String> shortMap(@NonNull Map<String, String> values, SORT_TYPE shortType) {
        try {
            Map<String, String> shortMap;
            if (shortType == SORT_TYPE.ASCENDING) {
                shortMap = new TreeMap<>(values);
            } else {
                shortMap = new TreeMap<>(Collections.reverseOrder());
                shortMap.putAll(values);
            }
            return shortMap;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String getISO8601Timestamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ", Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));
        return dateFormat.format(new Date());
    }

    public static String calcSignature(@NonNull String httpMethod, @NonNull String relativeUrlCanonical, @NonNull String accessToken, String hashRequestBodyCanonical, @NonNull String timestamp) {
        try {
            String strToSign = httpMethod + ":" + relativeUrlCanonical + ":" + accessToken + ":" + hashRequestBodyCanonical + ":" + timestamp;
            return calHmacSha256(strToSign, SECRET_KEY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
