package id.co.bca.sandbox.api_services.utils.networks.enums;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public enum HTTP_REQUEST_TYPE {
    REQ_ACCESS_TOKEN(0),
    REQ_BALANCE_INFO(1),
    REQ_ACCOUNT_STATEMENT(2),
    REQ_FUND_TRANSFER(3),
    REQ_DOMESTIC_FUND_TRANSFER(4),
    REQ_CREATE_PAYMENT(5),
    REQ_PAYMENT_STATUS(6);

    private int value;

    HTTP_REQUEST_TYPE(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
