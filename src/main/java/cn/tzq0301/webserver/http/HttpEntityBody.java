package cn.tzq0301.webserver.http;

import cn.tzq0301.webserver.web.EntityBody;

/**
 * @author TZQ
 * @Description TODO
 */
public class HttpEntityBody implements EntityBody {
    private byte[] content;

    public HttpEntityBody(byte[] content) {
        this.content = content;
    }

    @Override
    public byte[] getContent() {
        return content;
    }

    @Override
    public void setContent(byte[] content) {
        this.content = content;
    }
}
