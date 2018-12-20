package id.co.bca.sandbox.api_services.model.general_information.foreign_exchange_rate;

import java.util.List;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class Currencies {
    private String currencyCode;
    private List<RateDetail> rateDetails;

    public Currencies(String currencyCode, List<RateDetail> rateDetails) {
        this.currencyCode = currencyCode;
        this.rateDetails = rateDetails;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<RateDetail> getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(List<RateDetail> rateDetails) {
        this.rateDetails = rateDetails;
    }
}
