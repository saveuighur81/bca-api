package id.co.bca.sandbox.api_services.model.general_information.nearest_branch_location;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public class NearestBranchLocationRequest {
    private String latitude;
    private String longitude;
    private String count;
    private String radius;
    private String searchBy;
    private String value;

    public NearestBranchLocationRequest(String latitude, String longitude, String count, String radius, String searchBy, String value) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.count = count;
        this.radius = radius;
        this.searchBy = searchBy;
        this.value = value;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
