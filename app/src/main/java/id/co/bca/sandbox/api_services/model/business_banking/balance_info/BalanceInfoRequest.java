package id.co.bca.sandbox.api_services.model.business_banking.balance_info;

import java.util.List;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class BalanceInfoRequest {
    private String corporateID;
    private List<String> accountNumberList;

    public BalanceInfoRequest(String corporateID, List<String> accountNumberList) {
        this.corporateID = corporateID;
        this.accountNumberList = accountNumberList;
    }

    public String getCorporateID() {
        return corporateID;
    }

    public void setCorporateID(String corporateID) {
        this.corporateID = corporateID;
    }

    public List<String> getAccountNumberList() {
        return accountNumberList;
    }

    public void setAccountNumberList(List<String> accountNumberList) {
        this.accountNumberList = accountNumberList;
    }
}
