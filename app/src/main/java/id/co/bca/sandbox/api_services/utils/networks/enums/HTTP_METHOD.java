package id.co.bca.sandbox.api_services.utils.networks.enums;

/**
 * BCA API Sandbox
 *
 * @author ctechdev18@gmail.com
 * @version 1.0
 */
public enum HTTP_METHOD {
    DEPRECATED_GET_OR_POST(-1),
    GET(0),
    POST(1),
    PUT(2),
    DELETE(3),
    HEAD(4),
    OPTIONS(5),
    TRACE(6),
    PATCH(7);

    private int value;

    HTTP_METHOD(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
