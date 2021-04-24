package cn.tzq0301.webserver.servlet;

import cn.hutool.core.io.file.FileReader;
import cn.tzq0301.webserver.http.*;
import cn.tzq0301.webserver.util.TzqFileUtils;


/**
 * @author TZQ
 * @Description TODO
 */
public class SxrServlet implements Servlet {
    @Override
    public HttpResponse handleGET(HttpRequest request) {
        HttpResponseHeader header = new HttpResponseHeader(request.getRequestHeader().getHttpVersion(), HttpStatusCode.OK);
        header.setContentType("image/jpeg");
        final byte[] bytes = TzqFileUtils.classPathResourceToByteArray("static/img/sxr.jpg");
        header.setContentLength(bytes.length);
        HttpEntityBody body = new HttpEntityBody(bytes);
        return new HttpResponse(header, body);
    }

    @Override
    public HttpResponse handlePOST(HttpRequest request) {
        return handleGET(request);
    }
}
