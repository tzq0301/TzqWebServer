package cn.tzq0301.webserver.util;

import cn.tzq0301.webserver.http.HttpRequestMethod;
import cn.tzq0301.webserver.http.HttpVersion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TZQ
 * @Description TODO
 */
public final class TzqHttpUtils {
    private static final Map<String, HttpVersion> httpVersionMap;
    private static final Map<String, HttpRequestMethod> httpRequestMethodMap;

    static {
        Map<String, HttpVersion> tmpHttpVersionMap = new HashMap<>();
        tmpHttpVersionMap.put("HTTP/1.0", HttpVersion.HTTP_1_0);
        tmpHttpVersionMap.put("HTTP/1.1", HttpVersion.HTTP_1_1);
        tmpHttpVersionMap.put("HTTP/2", HttpVersion.HTTP_2);
        tmpHttpVersionMap.put("HTTP/3", HttpVersion.HTTP_3);
        httpVersionMap = Collections.unmodifiableMap(tmpHttpVersionMap);
    }

    static {
        Map<String, HttpRequestMethod> tmpHttpRequestMethodMap = new HashMap<>();
        tmpHttpRequestMethodMap.put("GET", HttpRequestMethod.GET);
        tmpHttpRequestMethodMap.put("POST", HttpRequestMethod.POST);
        tmpHttpRequestMethodMap.put("DELETE", HttpRequestMethod.DELETE);
        tmpHttpRequestMethodMap.put("PATCH", HttpRequestMethod.PATCH);
        tmpHttpRequestMethodMap.put("PUT", HttpRequestMethod.PUT);
        tmpHttpRequestMethodMap.put("HEAD", HttpRequestMethod.HEAD);
        tmpHttpRequestMethodMap.put("TRACE", HttpRequestMethod.TRACE);
        tmpHttpRequestMethodMap.put("OPTIONS", HttpRequestMethod.OPTIONS);
        tmpHttpRequestMethodMap.put("CONNECT", HttpRequestMethod.CONNECT);
        httpRequestMethodMap = Collections.unmodifiableMap(tmpHttpRequestMethodMap);
    }

    public static HttpVersion getHttpVersion(String httpVersion) {
        return httpVersionMap.get(httpVersion.toUpperCase());
    }

    public static HttpRequestMethod getHttpRequestMethod(String httpRequestMethod) {
        return httpRequestMethodMap.get(httpRequestMethod.toUpperCase());
    }

}
