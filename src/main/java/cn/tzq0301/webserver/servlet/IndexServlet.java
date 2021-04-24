package cn.tzq0301.webserver.servlet;

import cn.tzq0301.webserver.http.*;
import cn.tzq0301.webserver.util.TzqFileUtils;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

/**
 * @author TZQ
 * @Description TODO
 */
public class IndexServlet implements Servlet {
    @Override
    public HttpResponse handleGET(HttpRequest request) {
        HttpResponseHeader header = new HttpResponseHeader(request.getRequestHeader().getHttpVersion(), HttpStatusCode.OK);
        HttpEntityBody body = new HttpEntityBody(TzqFileUtils.classPathResourceToByteArray("static/index.html"));
        return new HttpResponse(header, body);
    }

    @Override
    public HttpResponse handlePOST(HttpRequest request) {
        return handleGET(request);
    }
}
