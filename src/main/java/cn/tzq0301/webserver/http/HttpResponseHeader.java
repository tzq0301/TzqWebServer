package cn.tzq0301.webserver.http;

import cn.tzq0301.webserver.util.HttpUtils;
import cn.tzq0301.webserver.web.Header;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TZQ
 * @Description TODO
 */
public class HttpResponseHeader implements Header {
    private final HttpVersion version;
    private final int code;
    private final String message;
    private final Map<String, String> headerFields = new HashMap<>();


    public HttpResponseHeader(HttpVersion version, HttpStatusCode httpStatusCode) {
        this.version = version;
        this.code = httpStatusCode.getCode();
        this.message = httpStatusCode.getMessage();
    }

    public HttpVersion getVersion() {
        return version;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String getAttribute(String attribute) {
        return headerFields.get(attribute);
    }

    @Override
    public Map<String, String> getAttributes() {
        return headerFields;
    }

    public void setAttribute(String attribute, String value) {
        headerFields.put(attribute, value);
    }

    public void setAttribute(HttpResponseHeaderAttribute attribute, String value) {
        setAttribute(attribute.attributeName, value);
    }

    public void setContentType(String contentType) {
        setAttribute(HttpResponseHeaderAttribute.ContentType, contentType);
    }

    public void setContentLength(int contentLength) {
        setAttribute(HttpResponseHeaderAttribute.ContentLength, String.valueOf(contentLength));
    }
}
