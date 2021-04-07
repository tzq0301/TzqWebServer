package cn.tzq0301.webserver.http;

import cn.tzq0301.webserver.web.EntityBody;

/**
 * @author TZQ
 * @Description TODO
 */
public class HttpEntityBody implements EntityBody {
    private String content;

    public HttpEntityBody(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}
