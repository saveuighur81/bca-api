package id.co.bca.sandbox.api_services.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Base64;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.co.bca.sandbox.api_services.model.authentication.AccessTokenPayload;
import id.co.bca.sandbox.api_services.model.authentication.AccessTokenRequest;
import id.co.bca.sandbox.api_services.model.authentication.AccessTokenRequestHeader;
import id.co.bca.sandbox.api_services.model.authentication.AccessTokenResponse;
import id.co.bca.sandbox.api_services.model.authentication.AccessTokenResult;
import id.co.bca.sandbox.api_services.model.business_banking.account_statement.AccountStatementRequest;
import id.co.bca.sandbox.api_services.model.business_banking.account_statement.AccountStatementResponse;
import id.co.bca.sandbox.api_services.model.business_banking.account_statement.AccountStatementResult;
import id.co.bca.sandbox.api_services.model.business_banking.account_statement.Data;
import id.co.bca.sandbox.api_services.model.business_banking.balance_info.BalanceInfoFailedResponse;
import id.co.bca.sandbox.api_services.model.business_banking.balance_info.BalanceInfoRequest;
import id.co.bca.sandbox.api_services.model.business_banking.balance_info.BalanceInfoResult;
import id.co.bca.sandbox.api_services.model.business_banking.balance_info.BalanceInfoSuccessResponse;
import id.co.bca.sandbox.api_services.model.business_banking.domestic_fund_transfer.DomesticFundTransferRequest;
import id.co.bca.sandbox.api_services.model.business_banking.domestic_fund_transfer.DomesticFundTransferResponse;
import id.co.bca.sandbox.api_services.model.business_banking.domestic_fund_transfer.DomesticFundTransferResult;
import id.co.bca.sandbox.api_services.model.business_banking.fund_transfer.FundTransferRequest;
import id.co.bca.sandbox.api_services.model.business_banking.fund_transfer.FundTransferResponse;
import id.co.bca.sandbox.api_services.model.business_banking.fund_transfer.FundTransferResult;
import id.co.bca.sandbox.api_services.model.sakuku.create_payment.CreatePaymentRequest;
import id.co.bca.sandbox.api_services.model.sakuku.create_payment.CreatePaymentResponse;
import id.co.bca.sandbox.api_services.model.sakuku.create_payment.CreatePaymentResult;
import id.co.bca.sandbox.api_services.model.sakuku.payment_status.PaymentStatusRequest;
import id.co.bca.sandbox.api_services.model.sakuku.payment_status.PaymentStatusResponse;
import id.co.bca.sandbox.api_services.model.sakuku.payment_status.PaymentStatusResult;
import id.co.bca.sandbox.api_services.model.sakuku.payment_status.ReasonStatus;
import id.co.bca.sandbox.api_services.utils.BcaApiContract;
import id.co.bca.sandbox.api_services.utils.networks.HttpRequest;
import id.co.bca.sandbox.api_services.utils.networks.HttpRequestController;
import id.co.bca.sandbox.api_services.utils.networks.enums.HTTP_METHOD;

import static id.co.bca.sandbox.api_services.Keys.API_KEY;
import static id.co.bca.sandbox.api_services.Keys.CLIENT_ID;
import static id.co.bca.sandbox.api_services.Keys.CLIENT_SECRET;
import static id.co.bca.sandbox.api_services.utils.networks.HttpParse.parseAccountStatementItem;
import static id.co.bca.sandbox.api_services.utils.networks.HttpParse.parseAccountStatementList;
import static id.co.bca.sandbox.api_services.utils.networks.HttpParse.parseBalanceFailedInfo;
import static id.co.bca.sandbox.api_services.utils.networks.HttpParse.parseBalanceSuccessInfo;
import static id.co.bca.sandbox.api_services.utils.networks.Utils.bodyCanonicalization;
import static id.co.bca.sandbox.api_services.utils.networks.Utils.calcSignature;
import static id.co.bca.sandbox.api_services.utils.networks.Utils.getISO8601Timestamp;
import static id.co.bca.sandbox.api_services.utils.networks.Utils.hashBodyCanonicalization;
import static id.co.bca.sandbox.api_services.utils.networks.Utils.headerCanonicalization;
import static id.co.bca.sandbox.api_services.utils.networks.Utils.urlCanonicalization;
import static id.co.bca.sandbox.api_services.utils.networks.enums.HTTP_REQUEST_TYPE.REQ_ACCESS_TOKEN;
import static id.co.bca.sandbox.api_services.utils.networks.enums.HTTP_REQUEST_TYPE.REQ_ACCOUNT_STATEMENT;
import static id.co.bca.sandbox.api_services.utils.networks.enums.HTTP_REQUEST_TYPE.REQ_BALANCE_INFO;
import static id.co.bca.sandbox.api_services.utils.networks.enums.HTTP_REQUEST_TYPE.REQ_DOMESTIC_FUND_TRANSFER;
import static id.co.bca.sandbox.api_services.utils.networks.enums.HTTP_REQUEST_TYPE.REQ_FUND_TRANSFER;
import static id.co.bca.sandbox.api_services.utils.networks.enums.HTTP_REQUEST_TYPE.REQ_PAYMENT_STATUS;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
@SuppressLint("StaticFieldLeak")
public class BcaApiPresenter implements BcaApiContract.Presenter.BusinessBanking, BcaApiContract.Presenter.Sakuku, BcaApiContract.Presenter.GeneralInformation, BcaApiContract.Presenter.Fire, BcaApiContract.Presenter.VirtualAccount, BcaApiContract.Presenter.Notification {
    public static final int RX_TIMEOUT_MS = 5000;
    private static final String HOST = "https://sandbox.bca.co.id:443";
    private static String accessToken = "";
    private static HttpRequestController httpRequestController;
    private static boolean isAccessTokenFinished, isBalanceInfoFinished, isAccountStatementFinished, isFundTransferFinished,
            isDomesticFundTransferFinished, isCreatePaymentFinished, isGetPaymentStatusFinished;

    public BcaApiPresenter(BcaApiContract.View view) {

    }

    @Override
    public void getAccessToken(final Context context, final AccessTokenResult accessTokenResult) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    isAccessTokenFinished = false;
                    String relativeUrlCanonical = urlCanonicalization("/api/oauth/token");

                    // accessTokenRequest
                    AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
                    accessTokenRequest.setHttpMethod(HTTP_METHOD.POST.getValue());
                    accessTokenRequest.setPath(relativeUrlCanonical);
                    accessTokenRequest.setHost(HOST);

                    // accessTokenRequestHeader
                    AccessTokenRequestHeader accessTokenRequestHeader = new AccessTokenRequestHeader();
                    accessTokenRequestHeader.setAuthorization("Basic " + Base64.encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes(), Base64.NO_WRAP));
                    accessTokenRequestHeader.setContentType("application/x-www-form-urlencoded");

                    // headerCanonical
                    Map<String, String> header = new HashMap<>();
                    header.put("Authorization", accessTokenRequestHeader.getAuthorization());
                    header.put("Content-Type", accessTokenRequestHeader.getContentType());
                    Map<String, String> headerCanonical = headerCanonicalization(header);

                    // accessTokenPayload
                    AccessTokenPayload accessTokenPayload = new AccessTokenPayload();
                    accessTokenPayload.setGrantType("client_credentials");

                    HttpRequest<JsonObject> httpRequest = new HttpRequest<>(accessTokenRequest, JsonObject.class, REQ_ACCESS_TOKEN, headerCanonical, null, accessTokenPayload,
                            new Response.Listener<JsonObject>() {
                                @Override
                                public void onResponse(JsonObject response) {
                                    if (response != null) {
                                        AccessTokenResponse accessToken = new AccessTokenResponse();
                                        accessToken.setAccessToken(response.get("access_token").getAsString());
                                        accessToken.setTokenType(response.get("token_type").getAsString());
                                        accessToken.setExpiresIn(response.get("expires_in").getAsString());
                                        accessToken.setScope(response.get("scope").getAsString());

                                        BcaApiPresenter.accessToken = accessToken.getAccessToken();

                                        accessTokenResult.onSuccess(accessToken);
                                        isAccessTokenFinished = true;
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError response) {
                                    if (response != null) {
                                        accessTokenResult.onError(response);
                                    }
                                }
                            });
                    httpRequestController = HttpRequestController.getInstance(context);
                    httpRequestController.addToRequestQueue(httpRequest);

                    long startWaiting = System.currentTimeMillis();
                    while (!isAccessTokenFinished || System.currentTimeMillis() - startWaiting < RX_TIMEOUT_MS) {
                        Thread.sleep(50);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                isAccessTokenFinished = true;
            }
        });
    }

    @Override
    public void getBalanceInfo(final Context context, final BalanceInfoRequest balanceInfoRequest, final BalanceInfoResult balanceInfoResult) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    isBalanceInfoFinished = false;

                    StringBuilder sbAccountNumbers = new StringBuilder();
                    List<String> accountNumberList = balanceInfoRequest.getAccountNumberList();
                    for (int i = 0; i < accountNumberList.size(); i++) {
                        sbAccountNumbers.append(accountNumberList.get(i));
                        if (i < accountNumberList.size() - 1) {
                            sbAccountNumbers.append(",");
                        }
                    }
                    String relativeUrlCanonical = urlCanonicalization("/banking/v3/corporates/" + balanceInfoRequest.getCorporateID() + "/accounts/" + sbAccountNumbers.toString());

                    // accessTokenRequest
                    AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
                    accessTokenRequest.setHttpMethod(HTTP_METHOD.GET.getValue());
                    accessTokenRequest.setPath(relativeUrlCanonical);
                    accessTokenRequest.setHost(HOST);

                    // headerCanonical
                    String timestamp = getISO8601Timestamp();
                    String signature = calcSignature(HTTP_METHOD.GET.name(), relativeUrlCanonical, accessToken, hashBodyCanonicalization(null), timestamp);
                    Map<String, String> header = new HashMap<>();
                    header.put("Authorization", "Bearer " + accessToken);
                    header.put("Content-Type", "application/json");
                    header.put("Origin", HOST);
                    header.put("X-BCA-Key", API_KEY);
                    header.put("X-BCA-Timestamp", timestamp);
                    header.put("X-BCA-Signature", signature);
                    Map<String, String> headerCanonical = headerCanonicalization(header);

                    // payloadCanonical
                    AccessTokenPayload accessTokenPayload = new AccessTokenPayload();
                    accessTokenPayload.setGrantType("client_credentials");

                    HttpRequest<JsonObject> httpRequest = new HttpRequest<>(accessTokenRequest, JsonObject.class, REQ_BALANCE_INFO, headerCanonical, null, accessTokenPayload,
                            new Response.Listener<JsonObject>() {
                                @Override
                                public void onResponse(JsonObject response) {
                                    if (response != null) {
                                        // success
                                        List<BalanceInfoSuccessResponse> balanceInfoSuccessList = new ArrayList<>();

                                        JsonArray balanceInfoSuccessJsonArray = parseBalanceSuccessInfo(response);
                                        if (balanceInfoSuccessJsonArray != null) {
                                            for (int i = 0; i < balanceInfoSuccessJsonArray.size(); i++) {

                                                JsonObject balanceInfoSuccessJson = balanceInfoSuccessJsonArray.get(i).getAsJsonObject();
                                                if (balanceInfoSuccessJson != null) {

                                                    BalanceInfoSuccessResponse balanceInfoSuccess = new BalanceInfoSuccessResponse();
                                                    if (balanceInfoSuccessJson.size() == 7) {
                                                        balanceInfoSuccess.setAccountNumber(balanceInfoSuccessJson.get("AccountNumber").getAsString());
                                                        balanceInfoSuccess.setCurrency(balanceInfoSuccessJson.get("Currency").getAsString());
                                                        balanceInfoSuccess.setBalance(balanceInfoSuccessJson.get("Balance").getAsString());
                                                        balanceInfoSuccess.setAvailableBalance(balanceInfoSuccessJson.get("AvailableBalance").getAsString());
                                                        balanceInfoSuccess.setFloatAmount(balanceInfoSuccessJson.get("FloatAmount").getAsString());
                                                        balanceInfoSuccess.setHoldAmount(balanceInfoSuccessJson.get("HoldAmount").getAsString());
                                                        balanceInfoSuccess.setPlafon(balanceInfoSuccessJson.get("Plafon").getAsString());
                                                    }
                                                    balanceInfoSuccessList.add(balanceInfoSuccess);
                                                }
                                            }
                                        }


                                        // failed
                                        List<BalanceInfoFailedResponse> balanceInfoFailedList = new ArrayList<>();

                                        JsonArray balanceInfoFailedJsonArray = parseBalanceFailedInfo(response);
                                        if (balanceInfoFailedJsonArray != null) {
                                            for (int i = 0; i < balanceInfoFailedJsonArray.size(); i++) {

                                                JsonObject balanceInfoFailedJson = balanceInfoFailedJsonArray.get(i).getAsJsonObject();
                                                if (balanceInfoFailedJson != null) {

                                                    BalanceInfoFailedResponse balanceInfoFailed = new BalanceInfoFailedResponse();
                                                    if (balanceInfoFailedJson.size() == 7) {
                                                        balanceInfoFailed.setEnglish(balanceInfoFailedJson.get("English").getAsString());
                                                        balanceInfoFailed.setIndonesian(balanceInfoFailedJson.get("Indonesian").getAsString());
                                                        balanceInfoFailed.setAccountNumber(balanceInfoFailedJson.get("AccountNumber").getAsString());
                                                    }
                                                    balanceInfoFailedList.add(balanceInfoFailed);
                                                }
                                            }
                                        }

                                        balanceInfoResult.onSuccess(balanceInfoSuccessList);
                                        balanceInfoResult.onFailed(balanceInfoFailedList);
                                        isBalanceInfoFinished = true;
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError response) {
                                    if (response != null) {
                                        balanceInfoResult.onError(response);
                                    }
                                }
                            });
                    httpRequestController = HttpRequestController.getInstance(context);
                    httpRequestController.addToRequestQueue(httpRequest);

                    long startWaiting = System.currentTimeMillis();
                    while (!isBalanceInfoFinished || System.currentTimeMillis() - startWaiting < RX_TIMEOUT_MS) {
                        Thread.sleep(50);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                isBalanceInfoFinished = true;
            }
        });
    }

    @Override
    public void getAccountStatement(final Context context, final AccountStatementRequest accountStatementRequest, final AccountStatementResult accountStatementResult) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    isAccountStatementFinished = false;
                    String relativeUrlCanonical = urlCanonicalization("/banking/v3/corporates/" + accountStatementRequest.getCorporateID() + "/accounts/" + accountStatementRequest.getAccountNumber() + "/statements?StartDate=" + accountStatementRequest.getStartDate() + "&EndDate=" + accountStatementRequest.getEndDate());

                    // accessTokenRequest
                    AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
                    accessTokenRequest.setHttpMethod(HTTP_METHOD.GET.getValue());
                    accessTokenRequest.setPath(relativeUrlCanonical);
                    accessTokenRequest.setHost(HOST);

                    // headerCanonical
                    String timestamp = getISO8601Timestamp();
                    String signature = calcSignature(HTTP_METHOD.GET.name(), relativeUrlCanonical, accessToken, hashBodyCanonicalization(null), timestamp);
                    Map<String, String> header = new HashMap<>();
                    header.put("Authorization", "Bearer " + accessToken);
                    header.put("Content-Type", "application/json");
                    header.put("Origin", HOST);
                    header.put("X-BCA-Key", API_KEY);
                    header.put("X-BCA-Timestamp", timestamp);
                    header.put("X-BCA-Signature", signature);
                    Map<String, String> headerCanonical = headerCanonicalization(header);

                    // payloadCanonical
                    AccessTokenPayload accessTokenPayload = new AccessTokenPayload();
                    accessTokenPayload.setGrantType("client_credentials");

                    HttpRequest<JsonObject> httpRequest = new HttpRequest<>(accessTokenRequest, JsonObject.class, REQ_ACCOUNT_STATEMENT, headerCanonical, null, accessTokenPayload,
                            new Response.Listener<JsonObject>() {
                                @Override
                                public void onResponse(JsonObject response) {
                                    try {
                                        if (response != null) {
                                            List<Data> dataList = new ArrayList<>();

                                            JsonArray accountStatementArray = parseAccountStatementItem(response);
                                            if (accountStatementArray != null) {
                                                for (int i = 0; i < accountStatementArray.size(); i++) {

                                                    JsonObject accountStatementJson = accountStatementArray.get(i).getAsJsonObject();
                                                    if (accountStatementJson != null) {

                                                        Data data = new Data();
                                                        data.setTransactionDate(accountStatementJson.get("TransactionDate").getAsString());
                                                        data.setBranchCode(accountStatementJson.get("BranchCode").getAsString());
                                                        data.setTransactionType(accountStatementJson.get("TransactionType").getAsString());
                                                        data.setTransactionAmount(accountStatementJson.get("TransactionAmount").getAsString());
                                                        data.setTransactionName(accountStatementJson.get("TransactionName").getAsString());
                                                        data.setTrailer(accountStatementJson.get("Trailer").getAsString());

                                                        dataList.add(data);
                                                    }
                                                }
                                            }

                                            JsonObject accountStatementJson = parseAccountStatementList(response);
                                            AccountStatementResponse accountStatement = new AccountStatementResponse();
                                            if (accountStatementJson != null) {
                                                accountStatement.setStartDate(accountStatementJson.get("StartDate").getAsString());
                                                accountStatement.setEndDate(accountStatementJson.get("EndDate").getAsString());
                                                accountStatement.setCurrency(accountStatementJson.get("Currency").getAsString());
                                                accountStatement.setStartBalance(accountStatementJson.get("StartBalance").getAsString());
                                                accountStatement.setDataTransaction(dataList);
                                            }

                                            accountStatementResult.onSuccess(accountStatement);
                                            isAccountStatementFinished = true;
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError response) {
                                    if (response != null) {
                                        accountStatementResult.onError(response);
                                    }
                                }
                            });
                    httpRequestController = HttpRequestController.getInstance(context);
                    httpRequestController.addToRequestQueue(httpRequest);

                    long startWaiting = System.currentTimeMillis();
                    while (!isAccountStatementFinished || System.currentTimeMillis() - startWaiting < RX_TIMEOUT_MS) {
                        Thread.sleep(50);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                isAccountStatementFinished = true;
            }
        });
    }

    @Override
    public void fundTransfer(final Context context, final FundTransferRequest fundTransferRequest, final FundTransferResult fundTransferResult) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    isFundTransferFinished = false;
                    String relativeUrlCanonical = urlCanonicalization("/banking/corporates/transfers");

                    // accessTokenRequest
                    AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
                    accessTokenRequest.setHttpMethod(HTTP_METHOD.POST.getValue());
                    accessTokenRequest.setPath(relativeUrlCanonical);
                    accessTokenRequest.setHost(HOST);

                    // requestBodyCanonical
                    Map<String, String> requestBody = new HashMap<>();
                    requestBody.put("CorporateID", fundTransferRequest.getCorporateId());
                    requestBody.put("SourceAccountNumber", fundTransferRequest.getSourceAccountNumber());
                    requestBody.put("TransactionID", fundTransferRequest.getTransactionId());
                    requestBody.put("TransactionDate", fundTransferRequest.getTransactionDate());
                    requestBody.put("ReferenceID", fundTransferRequest.getReferenceId());
                    requestBody.put("CurrencyCode", fundTransferRequest.getCurrencyCode());
                    requestBody.put("Amount", fundTransferRequest.getAmount());
                    requestBody.put("BeneficiaryAccountNumber", fundTransferRequest.getBeneficiaryAccountNumber());
                    requestBody.put("Remark1", fundTransferRequest.getRemark1());
                    requestBody.put("Remark2", fundTransferRequest.getRemark2());
                    Map<String, String> requestBodyCanonical = bodyCanonicalization(requestBody);

                    // headerCanonical
                    String timestamp = getISO8601Timestamp();
                    String signature = calcSignature(HTTP_METHOD.POST.name(), relativeUrlCanonical, accessToken, hashBodyCanonicalization(requestBody), timestamp);
                    Map<String, String> header = new HashMap<>();
                    header.put("Authorization", "Bearer " + accessToken);
                    header.put("Content-Type", "application/json");
                    header.put("Origin", HOST);
                    header.put("X-BCA-Key", API_KEY);
                    header.put("X-BCA-Timestamp", timestamp);
                    header.put("X-BCA-Signature", signature);
                    Map<String, String> headerCanonical = headerCanonicalization(header);

                    // payloadCanonical
                    AccessTokenPayload accessTokenPayload = new AccessTokenPayload();
                    accessTokenPayload.setGrantType("client_credentials");

                    HttpRequest<JsonObject> httpRequest = new HttpRequest<>(accessTokenRequest, JsonObject.class, REQ_FUND_TRANSFER, headerCanonical, requestBodyCanonical, accessTokenPayload,
                            new Response.Listener<JsonObject>() {
                                @Override
                                public void onResponse(JsonObject response) {
                                    try {
                                        if (response != null) {
                                            FundTransferResponse fundTransfer = new FundTransferResponse();
                                            fundTransfer.setTransactionId(response.get("TransactionID").getAsString());
                                            fundTransfer.setTransactionDate(response.get("TransactionDate").getAsString());
                                            fundTransfer.setReferenceId(response.get("ReferenceID").getAsString());
                                            fundTransfer.setStatus(response.get("Status").getAsString());

                                            fundTransferResult.onSuccess(fundTransfer);
                                            isFundTransferFinished = true;
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError response) {
                                    if (response != null) {
                                        fundTransferResult.onError(response);
                                    }
                                }
                            });
                    httpRequestController = HttpRequestController.getInstance(context);
                    httpRequestController.addToRequestQueue(httpRequest);

                    long startWaiting = System.currentTimeMillis();
                    while (!isFundTransferFinished || System.currentTimeMillis() - startWaiting < RX_TIMEOUT_MS) {
                        Thread.sleep(50);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                isFundTransferFinished = true;
            }
        });
    }

    @Override
    public void domesticFundTransfer(final Context context, final DomesticFundTransferRequest domesticFundTransferRequest, final DomesticFundTransferResult domesticFundTransferResult) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    isDomesticFundTransferFinished = false;
                    String relativeUrlCanonical = urlCanonicalization("/banking/corporates/transfers/domestic");

                    // accessTokenRequest
                    AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
                    accessTokenRequest.setHttpMethod(HTTP_METHOD.POST.getValue());
                    accessTokenRequest.setPath(relativeUrlCanonical);
                    accessTokenRequest.setHost(HOST);

                    // requestBodyCanonical
                    Map<String, String> requestBody = new HashMap<>();
                    requestBody.put("TransactionID", domesticFundTransferRequest.getTransactionID());
                    requestBody.put("TransactionDate", domesticFundTransferRequest.getTransactionDate());
                    requestBody.put("ReferenceID", domesticFundTransferRequest.getReferenceID());
                    requestBody.put("SourceAccountNumber", domesticFundTransferRequest.getSourceAccountNumber());
                    requestBody.put("BeneficiaryAccountNumber", domesticFundTransferRequest.getBeneficiaryAccountNumber());
                    requestBody.put("BeneficiaryBankCode", domesticFundTransferRequest.getBeneficiaryBankCode());
                    requestBody.put("BeneficiaryName", domesticFundTransferRequest.getBeneficiaryName());
                    requestBody.put("Amount", domesticFundTransferRequest.getAmount());
                    requestBody.put("TransferType", domesticFundTransferRequest.getTransferType());
                    requestBody.put("BeneficiaryCustType", domesticFundTransferRequest.getBeneficiaryCustType());
                    requestBody.put("BeneficiaryCustResidence", domesticFundTransferRequest.getBeneficiaryCustResidence());
                    requestBody.put("CurrencyCode", domesticFundTransferRequest.getCurrencyCode());
                    requestBody.put("Remark1", domesticFundTransferRequest.getRemark1());
                    requestBody.put("Remark2", domesticFundTransferRequest.getRemark2());
                    Map<String, String> requestBodyCanonical = bodyCanonicalization(requestBody);

                    // headerCanonical
                    String timestamp = getISO8601Timestamp();
                    String signature = calcSignature(HTTP_METHOD.POST.name(), relativeUrlCanonical, accessToken, hashBodyCanonicalization(requestBody), timestamp);
                    Map<String, String> header = new HashMap<>();
                    header.put("Authorization", "Bearer " + accessToken);
                    header.put("Content-Type", "application/json");
                    header.put("Origin", HOST);
                    header.put("X-BCA-Key", API_KEY);
                    header.put("X-BCA-Timestamp", timestamp);
                    header.put("X-BCA-Signature", signature);
                    header.put("ChannelID", domesticFundTransferRequest.getChannelID());
                    header.put("CredentialID", domesticFundTransferRequest.getCredentialID());
                    Map<String, String> headerCanonical = headerCanonicalization(header);

                    // payloadCanonical
                    AccessTokenPayload accessTokenPayload = new AccessTokenPayload();
                    accessTokenPayload.setGrantType("client_credentials");

                    HttpRequest<JsonObject> httpRequest = new HttpRequest<>(accessTokenRequest, JsonObject.class, REQ_DOMESTIC_FUND_TRANSFER, headerCanonical, requestBodyCanonical, accessTokenPayload,
                            new Response.Listener<JsonObject>() {
                                @Override
                                public void onResponse(JsonObject response) {
                                    try {
                                        if (response != null) {
                                            DomesticFundTransferResponse domesticFundTransfer = new DomesticFundTransferResponse();
                                            domesticFundTransfer.setTransactionID(response.get("TransactionID").getAsString());
                                            domesticFundTransfer.setTransactionDate(response.get("TransactionDate").getAsString());
                                            domesticFundTransfer.setReferenceID(response.get("ReferenceID").getAsString());
                                            domesticFundTransfer.setPPUNumber(response.get("PPUNumber").getAsString());

                                            domesticFundTransferResult.onSuccess(domesticFundTransfer);
                                            isDomesticFundTransferFinished = true;
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError response) {
                                    if (response != null) {
                                        domesticFundTransferResult.onError(response);
                                    }
                                }
                            });
                    httpRequestController = HttpRequestController.getInstance(context);
                    httpRequestController.addToRequestQueue(httpRequest);

                    long startWaiting = System.currentTimeMillis();
                    while (!isDomesticFundTransferFinished || System.currentTimeMillis() - startWaiting < RX_TIMEOUT_MS) {
                        Thread.sleep(50);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                isDomesticFundTransferFinished = true;
            }
        });
    }

    @Override
    public void createPayment(final Context context, final CreatePaymentRequest createPaymentRequest, final CreatePaymentResult createPaymentResult) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    isCreatePaymentFinished = false;
                    String relativeUrlCanonical = urlCanonicalization("/sakuku-commerce/payments");

                    // accessTokenRequest
                    AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
                    accessTokenRequest.setHttpMethod(HTTP_METHOD.POST.getValue());
                    accessTokenRequest.setPath(relativeUrlCanonical);
                    accessTokenRequest.setHost(HOST);

                    // requestBodyCanonical
                    Map<String, String> requestBody = new HashMap<>();
                    requestBody.put("MerchantID", createPaymentRequest.getMerchantID());
                    requestBody.put("MerchantName", createPaymentRequest.getMerchantName());
                    requestBody.put("Amount", createPaymentRequest.getAmount());
                    requestBody.put("Tax", createPaymentRequest.getTax());
                    requestBody.put("TransactionID", createPaymentRequest.getTransactionID());
                    requestBody.put("CurrencyCode", createPaymentRequest.getCurrencyCode());
                    requestBody.put("RequestDate", createPaymentRequest.getRequestDate());
                    requestBody.put("ReferenceID", createPaymentRequest.getReferenceID());
                    Map<String, String> requestBodyCanonical = bodyCanonicalization(requestBody);

                    // headerCanonical
                    String timestamp = getISO8601Timestamp();
                    String signature = calcSignature(HTTP_METHOD.POST.name(), relativeUrlCanonical, accessToken, hashBodyCanonicalization(requestBody), timestamp);
                    Map<String, String> header = new HashMap<>();
                    header.put("Authorization", "Bearer " + accessToken);
                    header.put("Content-Type", "application/json");
                    header.put("Origin", HOST);
                    header.put("X-BCA-Key", API_KEY);
                    header.put("X-BCA-Timestamp", timestamp);
                    header.put("X-BCA-Signature", signature);
                    Map<String, String> headerCanonical = headerCanonicalization(header);

                    // payloadCanonical
                    AccessTokenPayload accessTokenPayload = new AccessTokenPayload();
                    accessTokenPayload.setGrantType("client_credentials");

                    HttpRequest<JsonObject> httpRequest = new HttpRequest<>(accessTokenRequest, JsonObject.class, REQ_DOMESTIC_FUND_TRANSFER, headerCanonical, requestBodyCanonical, accessTokenPayload,
                            new Response.Listener<JsonObject>() {
                                @Override
                                public void onResponse(JsonObject response) {
                                    try {
                                        if (response != null) {
                                            CreatePaymentResponse createPaymentResponse = new CreatePaymentResponse();
                                            createPaymentResponse.setTransactionID(response.get("TransactionID").getAsString());
                                            createPaymentResponse.setPaymentID(response.get("PaymentID").getAsString());
                                            createPaymentResponse.setLandingPageURL(response.get("LandingPageURL").getAsString());

                                            createPaymentResult.onSuccess(createPaymentResponse);
                                            isCreatePaymentFinished = true;
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError response) {
                                    if (response != null) {
                                        createPaymentResult.onError(response);
                                    }
                                }
                            });
                    httpRequestController = HttpRequestController.getInstance(context);
                    httpRequestController.addToRequestQueue(httpRequest);

                    long startWaiting = System.currentTimeMillis();
                    while (!isCreatePaymentFinished || System.currentTimeMillis() - startWaiting < RX_TIMEOUT_MS) {
                        Thread.sleep(50);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                isCreatePaymentFinished = true;
            }
        });
    }

    @Override
    public void getPaymentStatus(final Context context, final PaymentStatusRequest paymentStatusRequest, final PaymentStatusResult paymentStatusResult) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    isGetPaymentStatusFinished = false;
                    String relativeUrlCanonical = urlCanonicalization("/sakuku-commerce/payments/" + paymentStatusRequest.getMerchantID() + "/" + paymentStatusRequest.getPaymentID());

                    // accessTokenRequest
                    AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
                    accessTokenRequest.setHttpMethod(HTTP_METHOD.GET.getValue());
                    accessTokenRequest.setPath(relativeUrlCanonical);
                    accessTokenRequest.setHost(HOST);

                    // headerCanonical
                    String timestamp = getISO8601Timestamp();
                    String signature = calcSignature(HTTP_METHOD.GET.name(), relativeUrlCanonical, accessToken, hashBodyCanonicalization(null), timestamp);
                    Map<String, String> header = new HashMap<>();
                    header.put("Authorization", "Bearer " + accessToken);
                    header.put("Content-Type", "application/json");
                    header.put("Origin", HOST);
                    header.put("X-BCA-Key", API_KEY);
                    header.put("X-BCA-Timestamp", timestamp);
                    header.put("X-BCA-Signature", signature);
                    Map<String, String> headerCanonical = headerCanonicalization(header);

                    // payloadCanonical
                    AccessTokenPayload accessTokenPayload = new AccessTokenPayload();
                    accessTokenPayload.setGrantType("client_credentials");

                    HttpRequest<JsonObject> httpRequest = new HttpRequest<>(accessTokenRequest, JsonObject.class, REQ_PAYMENT_STATUS, headerCanonical, null, accessTokenPayload,
                            new Response.Listener<JsonObject>() {
                                @Override
                                public void onResponse(JsonObject response) {
                                    try {
                                        if (response != null) {
                                            PaymentStatusResponse paymentStatusResponse = new PaymentStatusResponse();
                                            paymentStatusResponse.setPaymentID(response.get("PaymentID").getAsString());
                                            paymentStatusResponse.setAmount(response.get("Amount").getAsString());
                                            paymentStatusResponse.setRequestDate(response.get("RequestDate").getAsString());
                                            paymentStatusResponse.setPaymentStatus(response.get("PaymentStatus").getAsString());

                                            JsonObject reasonStatusJson = response.get("ReasonStatus").getAsJsonObject();
                                            if (reasonStatusJson != null) {
                                                ReasonStatus reasonStatus = new ReasonStatus();
                                                reasonStatus.setIndonesian(reasonStatusJson.get("Indonesian").getAsString());
                                                reasonStatus.setEnglish(reasonStatusJson.get("English").getAsString());
                                                paymentStatusResponse.setReasonStatus(reasonStatus);
                                            }

                                            paymentStatusResult.onSuccess(paymentStatusResponse);
                                            isGetPaymentStatusFinished = true;
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError response) {
                                    if (response != null) {
                                        paymentStatusResult.onError(response);
                                    }
                                }
                            });
                    httpRequestController = HttpRequestController.getInstance(context);
                    httpRequestController.addToRequestQueue(httpRequest);

                    long startWaiting = System.currentTimeMillis();
                    while (!isGetPaymentStatusFinished || System.currentTimeMillis() - startWaiting < RX_TIMEOUT_MS) {
                        Thread.sleep(50);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                isGetPaymentStatusFinished = true;
            }
        });
    }

}
