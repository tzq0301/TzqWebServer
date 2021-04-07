package cn.tzq0301.webserver.http;

import cn.tzq0301.webserver.web.Request;

/**
 * @author TZQ
 * @Description TODO
 */
public class HttpRequest implements Request {
    private final HttpRequestHeader header;
    private final HttpEntityBody body;

    public HttpRequest(HttpRequestHeader header, HttpEntityBody body) {
        this.header = header;
        this.body = body;
    }

    @Override
    public HttpRequestHeader getRequestHeader() {
        return header;
    }

    @Override
    public HttpEntityBody getEntityBody() {
        return body;
    }
}
