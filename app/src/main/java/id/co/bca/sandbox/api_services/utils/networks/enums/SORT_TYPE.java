package id.co.bca.sandbox.api_services.utils.networks.enums;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public enum SORT_TYPE {
    ASCENDING(0),
    DESCENDING(1);

    private int value;

    SORT_TYPE(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
