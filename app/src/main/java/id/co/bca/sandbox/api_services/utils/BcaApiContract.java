package id.co.bca.sandbox.api_services.utils;

import android.content.Context;

import id.co.bca.sandbox.api_services.model.authentication.AccessTokenResult;
import id.co.bca.sandbox.api_services.model.business_banking.account_statement.AccountStatementRequest;
import id.co.bca.sandbox.api_services.model.business_banking.account_statement.AccountStatementResult;
import id.co.bca.sandbox.api_services.model.business_banking.balance_info.BalanceInfoRequest;
import id.co.bca.sandbox.api_services.model.business_banking.balance_info.BalanceInfoResult;
import id.co.bca.sandbox.api_services.model.business_banking.domestic_fund_transfer.DomesticFundTransferRequest;
import id.co.bca.sandbox.api_services.model.business_banking.domestic_fund_transfer.DomesticFundTransferResult;
import id.co.bca.sandbox.api_services.model.business_banking.fund_transfer.FundTransferRequest;
import id.co.bca.sandbox.api_services.model.business_banking.fund_transfer.FundTransferResult;
import id.co.bca.sandbox.api_services.model.sakuku.create_payment.CreatePaymentRequest;
import id.co.bca.sandbox.api_services.model.sakuku.create_payment.CreatePaymentResult;
import id.co.bca.sandbox.api_services.model.sakuku.payment_status.PaymentStatusRequest;
import id.co.bca.sandbox.api_services.model.sakuku.payment_status.PaymentStatusResult;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public interface BcaApiContract {
    interface View {

    }

    interface Presenter {

        interface BusinessBanking {
            void getAccessToken(final Context context, final AccessTokenResult accessTokenResult);

            void getBalanceInfo(final Context context, final BalanceInfoRequest balanceInfoRequest, final BalanceInfoResult balanceInfoResult);

            void getAccountStatement(final Context context, final AccountStatementRequest accountStatementRequest, final AccountStatementResult accountStatementResult);

            void fundTransfer(final Context context, final FundTransferRequest fundTransferRequest, final FundTransferResult fundTransferResult);

            void domesticFundTransfer(final Context context, final DomesticFundTransferRequest domesticFundTransferRequest, final DomesticFundTransferResult domesticFundTransferResult);
        }

        interface Sakuku {
            void createPayment(final Context context, final CreatePaymentRequest createPaymentRequest, final CreatePaymentResult createPaymentResult);

            void getPaymentStatus(final Context context, final PaymentStatusRequest paymentStatusRequest, final PaymentStatusResult paymentStatusResult);
        }

        interface GeneralInformation {

        }

        interface Fire {

        }

        interface VirtualAccount {

        }

        interface Notification {

        }
    }

}
