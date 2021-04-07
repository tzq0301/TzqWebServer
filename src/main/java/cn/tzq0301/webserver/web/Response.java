package cn.tzq0301.webserver.web;

public interface Response {
    Header getResponseHeader();
    EntityBody getEntityBody();
    byte[] toMessage();
}
