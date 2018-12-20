package id.co.bca.sandbox.api_services.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.co.bca.sandbox.R;
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
import id.co.bca.sandbox.api_services.presenter.BcaApiPresenter;
import id.co.bca.sandbox.api_services.utils.BcaApiContract;

import static id.co.bca.sandbox.api_services.utils.networks.HttpParse.parseVolleyError;
import static id.co.bca.sandbox.api_services.utils.networks.Utils.getCurrrentDate;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class BcaApiView extends AppCompatActivity implements BcaApiContract.View {
    private TextView logTextView;
    private BcaApiPresenter bcaApiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();

        // instance of presenter
        this.bcaApiPresenter = new BcaApiPresenter(this);

        // BCA api services
        BcaApiServices();
    }

    private void initViews() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        logTextView = findViewById(R.id.log_textview);
        logTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    private void BcaApiServices() {
        authentication();

        businessBanking();
        sakuku();

        /*
        ////////// belum dicoding ///////////
        generalInformation();
        fire();
        virtualAccount();
        notification();
        */
    }

    private void authentication() {

        this.bcaApiPresenter.getAccessToken(this, new AccessTokenResult() {
            @Override
            public void onSuccess(AccessTokenResponse response) {
                try {
                    if (response != null) {
                        logTextView.append("-- ACCESS TOKEN  --\n");
                        logTextView.append("access_token: { " + response.getAccessToken() + " }\n");
                        logTextView.append("token_type: { " + response.getTokenType() + " }\n");
                        logTextView.append("expires_in: { " + response.getExpiresIn() + " }\n");
                        logTextView.append("scope: { " + response.getScope() + " }\n");
                        logTextView.append("\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError response) {
                try {
                    logTextView.append("-- ACCESS TOKEN  --\n");
                    logTextView.append(parseVolleyError("getAccessToken()", response) + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void businessBanking() {

        this.bcaApiPresenter.getBalanceInfo(this, new BalanceInfoRequest("BCAAPI2016", new ArrayList<>(Arrays.asList("0201245680", "0063001004"))), new BalanceInfoResult() {

            @Override
            public void onSuccess(List<BalanceInfoSuccessResponse> response) {
                try {
                    if (response != null && response.size() > 0) {
                        logTextView.append("-- BALANCE INFORMATION --\n");

                        for (int i = 0; i < response.size(); i++) {
                            BalanceInfoSuccessResponse successResponse = response.get(i);
                            if (successResponse != null) {
                                logTextView.append("account_number: { " + successResponse.getAccountNumber() + " }\n");
                                logTextView.append("currency: { " + successResponse.getCurrency() + " }\n");
                                logTextView.append("balance: { " + successResponse.getBalance() + " }\n");
                                logTextView.append("available_balance: { " + successResponse.getAvailableBalance() + " }\n");
                                logTextView.append("float_amount: { " + successResponse.getFloatAmount() + " }\n");
                                logTextView.append("hold_amount: { " + successResponse.getHoldAmount() + " }\n");
                                logTextView.append("plafon: { " + successResponse.getPlafon() + " }\n");
                                logTextView.append("\n");
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailed(List<BalanceInfoFailedResponse> response) {
                try {
                    if (response != null && response.size() > 0) {
                        logTextView.append("-- BALANCE INFORMATION --\n");

                        for (int i = 0; i < response.size(); i++) {
                            BalanceInfoFailedResponse failedResponse = response.get(i);
                            if (failedResponse != null) {
                                logTextView.append("English: { " + failedResponse.getEnglish() + " }\n");
                                logTextView.append("Indonesian: { " + failedResponse.getIndonesian() + " }\n");
                                logTextView.append("AccountNumber: { " + failedResponse.getAccountNumber() + " }\n");
                                logTextView.append("\n");
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError response) {
                try {
                    logTextView.append("-- BALANCE INFORMATION --\n");
                    logTextView.append(parseVolleyError("getBalanceInfo()", response) + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.bcaApiPresenter.getAccountStatement(this, new AccountStatementRequest("BCAAPI2016", "0201245680", "2016-09-01", "2016-09-01"), new AccountStatementResult() {
            @Override
            public void onSuccess(AccountStatementResponse response) {
                try {
                    if (response != null) {
                        logTextView.append("-- ACCOUNT STATEMENT --\n");
                        logTextView.append("start_date: { " + response.getStartDate() + " }\n");
                        logTextView.append("end_date: { " + response.getEndDate() + " }\n");
                        logTextView.append("currency: { " + response.getCurrency() + " }\n");
                        logTextView.append("start_balance: { " + response.getStartBalance() + " }\n\n");

                        List<Data> list = response.getDataTransaction();
                        if (list != null) {
                            for (int i = 0; i < list.size(); i++) {
                                Data item = list.get(i);
                                if (item != null) {
                                    int n = i + 1;
                                    logTextView.append("\t" + n + ".\ttransaction_date: { " + item.getTransactionDate() + " }\n");
                                    logTextView.append("\t" + " " + "\t\tbranch_code: { " + item.getBranchCode() + " }\n");
                                    logTextView.append("\t" + " " + "\t\ttransaction_type: { " + item.getTransactionType() + " }\n");
                                    logTextView.append("\t" + " " + "\t\ttransaction_amount: { " + item.getTransactionAmount() + " }\n");
                                    logTextView.append("\t" + " " + "\t\ttransaction_name: { " + item.getTransactionName() + " }\n");
                                    logTextView.append("\t" + " " + "\t\ttransaction_trailer: { " + item.getTrailer() + " }\n\n");
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError response) {
                try {
                    if (response != null) {
                        logTextView.append("-- ACCOUNT STATEMENT --\n");
                        logTextView.append(parseVolleyError("getAccountStatement()", response) + "\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.bcaApiPresenter.fundTransfer(this, new FundTransferRequest("BCAAPI2016", "0201245680", "00000001", getCurrrentDate(), "12345/PO/2018", "IDR", "100000.00", "0201245681", "Transfer Test", "Online Transfer"), new FundTransferResult() {
            @Override
            public void onSuccess(FundTransferResponse response) {
                try {
                    if (response != null) {
                        logTextView.append("-- FUND TRANSFER --\n");
                        logTextView.append("transaction_id: { " + response.getTransactionId() + " }\n");
                        logTextView.append("transaction_date: { " + response.getTransactionDate() + " }\n");
                        logTextView.append("reference_id: { " + response.getReferenceId() + " }\n");
                        logTextView.append("status: { " + response.getStatus() + " }\n");
                        logTextView.append("\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError response) {
                try {
                    if (response != null) {
                        logTextView.append("-- FUND TRANSFER --\n");
                        logTextView.append(parseVolleyError("fundTransfer()", response) + "\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.bcaApiPresenter.domesticFundTransfer(this, new DomesticFundTransferRequest("00000001", "2016-01-30", "12345/PO/2016", "0201245680", "0201245681", "BRINIDJA", "Tester", "100000.00", "LLG", "1", "1", "IDR", "Transfer Test", "Online Transfer", "95051", "BCAAPI"), new DomesticFundTransferResult() {
            @Override
            public void onSuccess(DomesticFundTransferResponse response) {
                try {
                    if (response != null) {
                        logTextView.append("-- DOMESTIC FUND TRANSFER --\n");
                        logTextView.append("transaction_id: { " + response.getTransactionID() + " }\n");
                        logTextView.append("transaction_date: { " + response.getTransactionDate() + " }\n");
                        logTextView.append("reference_id: { " + response.getReferenceID() + " }\n");
                        logTextView.append("ppu_number: { " + response.getPPUNumber() + " }\n");
                        logTextView.append("\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError response) {
                try {
                    if (response != null) {
                        logTextView.append("-- DOMESTIC FUND TRANSFER --\n");
                        logTextView.append(parseVolleyError("domesticFundTransfer()", response) + "\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void sakuku() {

        this.bcaApiPresenter.createPayment(this, new CreatePaymentRequest("89000", "Merchant One", "100.22", "0.0", "156479", "IDR", "2015-04-29T09:54:00.234+07:00", "123465798"), new CreatePaymentResult() {
            @Override
            public void onSuccess(CreatePaymentResponse response) {
                try {
                    if (response != null) {
                        logTextView.append("-- CREATE PAYMENT  --\n");
                        logTextView.append("transaction_id: { " + response.getTransactionID() + " }\n");
                        logTextView.append("payment_id: { " + response.getPaymentID() + " }\n");
                        logTextView.append("landing_page_url: { " + response.getLandingPageURL() + " }\n");
                        logTextView.append("\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError response) {
                try {
                    logTextView.append("-- CREATE PAYMENT  --\n");
                    logTextView.append(parseVolleyError("createPayment()", response) + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.bcaApiPresenter.getPaymentStatus(this, new PaymentStatusRequest("89000", "0FE117D539DF610FE0540021281A5568"), new PaymentStatusResult() {
            @Override
            public void onSuccess(PaymentStatusResponse response) {
                try {
                    if (response != null) {
                        logTextView.append("-- PAYMENT STATUS  --\n");
                        logTextView.append("payment_id: { " + response.getPaymentID() + " }\n");
                        logTextView.append("amount: { " + response.getAmount() + " }\n");
                        logTextView.append("request_date: { " + response.getRequestDate() + " }\n");
                        logTextView.append("payment_status: { " + response.getPaymentStatus() + " }\n");
                        logTextView.append("reason_status_indonesian: { " + response.getReasonStatus().getIndonesian() + " }\n");
                        logTextView.append("reason_status_english: { " + response.getReasonStatus().getEnglish() + " }\n");
                        logTextView.append("\n");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onError(VolleyError response) {
                try {
                    logTextView.append("-- PAYMENT STATUS  --\n");
                    logTextView.append(parseVolleyError("getPaymentStatus()", response) + "\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
