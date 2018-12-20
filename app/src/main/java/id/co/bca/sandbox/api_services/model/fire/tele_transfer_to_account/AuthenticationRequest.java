package id.co.bca.sandbox.api_services.model.fire.tele_transfer_to_account;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class AuthenticationRequest {
    private String corporateID;
    private String accessCode;
    private String branchCode;
    private String userID;
    private String localID;

    public AuthenticationRequest(String corporateID, String accessCode, String branchCode, String userID, String localID) {
        this.corporateID = corporateID;
        this.accessCode = accessCode;
        this.branchCode = branchCode;
        this.userID = userID;
        this.localID = localID;
    }

    public String getCorporateID() {
        return corporateID;
    }

    public void setCorporateID(String corporateID) {
        this.corporateID = corporateID;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }
}
