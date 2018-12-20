package id.co.bca.sandbox.api_services.model.general_information.nearest_branch_location;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class NearestBranchLocationResponse {
    private String type;
    private String name;
    private String address;
    private String city;
    private String country;
    private String latitude;
    private String longitude;
    private String distance;
    private String eBranch;
    private String weekendBankingOperation;

    public NearestBranchLocationResponse(String type, String name, String address, String city, String country, String latitude, String longitude, String distance, String eBranch, String weekendBankingOperation) {
        this.type = type;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.eBranch = eBranch;
        this.weekendBankingOperation = weekendBankingOperation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String geteBranch() {
        return eBranch;
    }

    public void seteBranch(String eBranch) {
        this.eBranch = eBranch;
    }

    public String getWeekendBankingOperation() {
        return weekendBankingOperation;
    }

    public void setWeekendBankingOperation(String weekendBankingOperation) {
        this.weekendBankingOperation = weekendBankingOperation;
    }
}

