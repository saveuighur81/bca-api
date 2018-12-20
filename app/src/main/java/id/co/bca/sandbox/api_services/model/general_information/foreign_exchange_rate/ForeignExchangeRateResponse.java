package id.co.bca.sandbox.api_services.model.general_information.foreign_exchange_rate;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class ForeignExchangeRateResponse {
    private Currencies currencies;
    private String invalidRateType;
    private String invalidCurrency;

    public ForeignExchangeRateResponse(Currencies currencies, String invalidRateType, String invalidCurrency) {
        this.currencies = currencies;
        this.invalidRateType = invalidRateType;
        this.invalidCurrency = invalidCurrency;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public String getInvalidRateType() {
        return invalidRateType;
    }

    public void setInvalidRateType(String invalidRateType) {
        this.invalidRateType = invalidRateType;
    }

    public String getInvalidCurrency() {
        return invalidCurrency;
    }

    public void setInvalidCurrency(String invalidCurrency) {
        this.invalidCurrency = invalidCurrency;
    }
}
