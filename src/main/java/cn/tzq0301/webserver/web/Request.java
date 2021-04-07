package cn.tzq0301.webserver.web;

public interface Request {
    Header getRequestHeader();
    EntityBody getEntityBody();
}
