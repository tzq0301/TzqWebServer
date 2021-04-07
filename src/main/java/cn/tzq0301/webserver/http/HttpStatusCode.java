package cn.tzq0301.webserver.http;

public enum HttpStatusCode {
    OK(200, "OK"),
    NOT_FOUNT(404, "Not Found"),
    METHOD_NOT_ALLOW(405, "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    HTTP_VERSION_NOT_SUPPORTS(505, "HTTP Version Not Supported");

    private final Integer code;
    private final String message;

    HttpStatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
