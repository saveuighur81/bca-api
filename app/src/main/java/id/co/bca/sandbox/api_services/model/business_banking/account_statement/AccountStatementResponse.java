package id.co.bca.sandbox.api_services.model.business_banking.account_statement;

import java.util.ArrayList;
import java.util.List;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class AccountStatementResponse {
    private String startDate;
    private String endDate;
    private String currency;
    private String startBalance;
    private List<Data> data = new ArrayList<>();

    public AccountStatementResponse(String startDate, String endDate, String currency, String startBalance, List<Data> data) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
        this.startBalance = startBalance;
        this.data = data;
    }

    public AccountStatementResponse() {

    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStartBalance() {
        return this.startBalance;
    }

    public void setStartBalance(String startBalance) {
        this.startBalance = startBalance;
    }

    public List<Data> getDataTransaction() {
        return this.data;
    }

    public void setDataTransaction(List<Data> data) {
        this.data = data;
    }
}
