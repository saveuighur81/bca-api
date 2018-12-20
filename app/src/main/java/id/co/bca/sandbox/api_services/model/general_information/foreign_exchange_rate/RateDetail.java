package id.co.bca.sandbox.api_services.model.general_information.foreign_exchange_rate;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class RateDetail {
    private String rateType;
    private String buy;
    private String sell;
    private String lastUpdate;

    public RateDetail(String rateType, String buy, String sell, String lastUpdate) {
        this.rateType = rateType;
        this.buy = buy;
        this.sell = sell;
        this.lastUpdate = lastUpdate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
