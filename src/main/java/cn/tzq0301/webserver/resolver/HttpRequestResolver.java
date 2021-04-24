package cn.tzq0301.webserver.resolver;

import cn.tzq0301.webserver.http.HttpEntityBody;
import cn.tzq0301.webserver.http.HttpRequest;
import cn.tzq0301.webserver.http.HttpRequestHeader;
import cn.tzq0301.webserver.util.HttpUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TZQ
 * @Description TODO
 */
public class HttpRequestResolver {
    private static final String SPACE = " ";
    private static final String CRLF = "\r\n";
    private static final String CRLFCRLF = "\r\n\r\n";

    public static HttpRequest resolve(byte[] bytes, int len) {
        String message = new String(bytes, 0, len);

        int startOfBlankLine = message.indexOf(CRLFCRLF);
        HttpEntityBody body = new HttpEntityBody(
                message.substring(startOfBlankLine + CRLFCRLF.length()).getBytes(StandardCharsets.UTF_8));

        String[] strings = message.split("\\r\\n");

        Map<String, String> headerFields = new HashMap<>();
        for (int i = 1; i < strings.length - 2; i++) {
            int indexOfColon = strings[i].indexOf(":");
            headerFields.put(
                    strings[i].substring(0, indexOfColon).trim(),
                    strings[i].substring(indexOfColon + 1).trim());
        }

        String[] headerLine = strings[0].split(SPACE);
        HttpRequestHeader header = new HttpRequestHeader(HttpUtils.getHttpRequestMethod(headerLine[0]),
                headerLine[1], HttpUtils.getHttpVersion(headerLine[2]), headerFields);

        return new HttpRequest(header, body);
    }
}
