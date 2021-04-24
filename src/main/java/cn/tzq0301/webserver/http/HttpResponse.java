package cn.tzq0301.webserver.http;

import cn.hutool.core.util.ArrayUtil;
import cn.tzq0301.webserver.web.EntityBody;
import cn.tzq0301.webserver.web.Header;
import cn.tzq0301.webserver.web.Response;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author TZQ
 * @Description TODO
 */
public class HttpResponse implements Response {
    private static final String CRLF = "\r\n";
    private static final String SPACE = " ";

    private final HttpResponseHeader header;
    private final HttpEntityBody body;

    public HttpResponse(HttpResponseHeader header, HttpEntityBody body) {
        this.header = header;
        this.body = body;
    }

    public void addHeaderField(String attribute, String value) {
        header.setAttribute(attribute, value);
    }

    @Override
    public Header getResponseHeader() {
        return header;
    }

    @Override
    public EntityBody getEntityBody() {
        return body;
    }

    @Override
    public byte[] toMessage() {
        final StringBuilder stringBuilder = new StringBuilder()
                .append(header.getVersion()).append(SPACE)
                .append(header.getCode()).append(SPACE)
                .append(header.getMessage()).append(CRLF);
        header.getAttributes().forEach((k, v) -> stringBuilder.append(k).append(": ").append(v).append(CRLF));
        stringBuilder.append(CRLF);

        return ArrayUtil.addAll(stringBuilder.toString().getBytes(StandardCharsets.UTF_8), body.getContent());
    }
}
