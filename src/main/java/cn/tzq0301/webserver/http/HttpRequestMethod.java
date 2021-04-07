package cn.tzq0301.webserver.http;

public enum HttpRequestMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH"),
    HEAD("HEAD"),
    TRACE("TRACE"),
    OPTIONS("OPTIONS"),
    CONNECT("CONNECT");

    private final String method;

    HttpRequestMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
