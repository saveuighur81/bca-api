package id.co.bca.sandbox.api_services.model.general_information.foreign_exchange_rate;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class ForeignExchangeRateRequest {
    private String currencyCode;
    private String rateType;

    public ForeignExchangeRateRequest(String currencyCode, String rateType) {
        this.currencyCode = currencyCode;
        this.rateType = rateType;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }
}
