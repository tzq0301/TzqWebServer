package cn.tzq0301.webserver.handler;

import cn.tzq0301.webserver.http.HttpRequest;
import cn.tzq0301.webserver.http.HttpRequestMethod;
import cn.tzq0301.webserver.http.HttpResponse;
import cn.tzq0301.webserver.servlet.IndexServlet;
import cn.tzq0301.webserver.servlet.Servlet;
import cn.tzq0301.webserver.servlet.SxrServlet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TZQ
 * @Description TODO
 */
public class Dispatcher {
    private static final Map<String, Servlet> requestMap;

    static {
        Map<String, Servlet> tmp = new HashMap<>();

        tmp.put("/index", new IndexServlet());
        tmp.put("/img/sxr.jpg", new SxrServlet());

        requestMap = Collections.unmodifiableMap(tmp);
    }

    public static HttpResponse handle(HttpRequest request) {
        return requestMap.get(request.getRequestHeader().getUrl())
                .handle(request, request.getRequestHeader().getMethod());
    }
}
