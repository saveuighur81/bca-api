package id.co.bca.sandbox.api_services.model.sakuku.payment_status;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class ReasonStatus {
    private String indonesian;
    private String english;

    public ReasonStatus(String indonesian, String english) {
        this.indonesian = indonesian;
        this.english = english;
    }

    public ReasonStatus() {

    }

    public String getIndonesian() {
        return indonesian;
    }

    public void setIndonesian(String indonesian) {
        this.indonesian = indonesian;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
