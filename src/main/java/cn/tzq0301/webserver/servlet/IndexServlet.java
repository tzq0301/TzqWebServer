package cn.tzq0301.webserver.servlet;

import cn.tzq0301.webserver.http.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author TZQ
 * @Description TODO
 */
public class IndexServlet implements Servlet {
    @Override
    public HttpResponse handleGET(HttpRequest request) {
        HttpResponseHeader header = new HttpResponseHeader(request.getRequestHeader().getHttpVersion(), HttpStatusCode.OK);
        StringBuilder stringBuilder = new StringBuilder();
        try (final InputStream inputStream = new ClassPathResource("static/index.html").getInputStream()) {
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1) {
                stringBuilder.append(new String(buf, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntityBody body = new HttpEntityBody(stringBuilder.toString());
        return new HttpResponse(header, body);
    }

    @Override
    public HttpResponse handlePOST(HttpRequest request) {
        return handleGET(request);
    }
}
