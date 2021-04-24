package cn.tzq0301.webserver.servlet;

import cn.hutool.core.io.file.FileReader;
import cn.tzq0301.webserver.http.*;
import cn.tzq0301.webserver.util.TzqFileUtils;

/**
 * @author TZQ
 * @Description TODO
 */
public class IndexCssServlet implements Servlet {
    @Override
    public HttpResponse handleGET(HttpRequest request) {
        HttpResponseHeader header = new HttpResponseHeader(request.getRequestHeader().getHttpVersion(), HttpStatusCode.OK);
        final byte[] bytes = TzqFileUtils.classPathResourceToByteArray("static/css/index.css");
        HttpEntityBody body = new HttpEntityBody(bytes);
        return new HttpResponse(header, body);
    }

    @Override
    public HttpResponse handlePOST(HttpRequest request) {
        return handleGET(request);
    }
}
