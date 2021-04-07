package cn.tzq0301.webserver.web;

import java.util.Map;

public interface Header {
    String getAttribute(String attribute);

    Map<String, String> getAttributes();
}
