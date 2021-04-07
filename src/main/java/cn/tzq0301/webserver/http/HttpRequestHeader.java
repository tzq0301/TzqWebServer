package cn.tzq0301.webserver.http;

import cn.tzq0301.webserver.util.HttpUtils;
import cn.tzq0301.webserver.web.Header;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TZQ
 * @Description TODO
 */
public class HttpRequestHeader implements Header {
    private final HttpRequestMethod method;
    private final String url;
    private final HttpVersion httpVersion;

    private final Map<String, String> headerFields;

    public HttpRequestHeader(HttpRequestMethod method, String url, HttpVersion httpVersion, Map<String, String> headerFields) {
        this.method = method;
        this.url = url;
        this.httpVersion = httpVersion;
        this.headerFields = headerFields;
    }

    public HttpRequestMethod getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public HttpVersion getHttpVersion() {
        return httpVersion;
    }

    @Override
    public String getAttribute(String attribute) {
        return headerFields.get(attribute);
    }

    @Override
    public Map<String, String> getAttributes() {
        return new HashMap<>(headerFields);
    }
}
