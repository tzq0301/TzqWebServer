package cn.tzq0301.webserver.http;

public enum HttpResponseHeaderAttribute {
    ContentType("Content-Type"),
    ContentLength("Content-Length");

    public String attributeName;

    HttpResponseHeaderAttribute(String attributeName) {
        this.attributeName = attributeName;
    }
}
