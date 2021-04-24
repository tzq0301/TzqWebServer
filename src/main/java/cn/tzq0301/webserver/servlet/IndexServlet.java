package cn.tzq0301.webserver.servlet;

import cn.hutool.core.io.file.FileReader;
import cn.tzq0301.webserver.http.*;

/**
 * @author TZQ
 * @Description TODO
 */
public class IndexServlet implements Servlet {
    @Override
    public HttpResponse handleGET(HttpRequest request) {
        HttpResponseHeader header = new HttpResponseHeader(request.getRequestHeader().getHttpVersion(), HttpStatusCode.OK);
        FileReader fileReader = new FileReader("static/index.html");
        final byte[] bytes = fileReader.readBytes();
        HttpEntityBody body = new HttpEntityBody(bytes);
        return new HttpResponse(header, body);
    }

    @Override
    public HttpResponse handlePOST(HttpRequest request) {
        return handleGET(request);
    }
}
