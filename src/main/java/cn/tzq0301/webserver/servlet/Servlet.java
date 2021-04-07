package cn.tzq0301.webserver.servlet;

import cn.tzq0301.webserver.http.HttpRequest;
import cn.tzq0301.webserver.http.HttpRequestMethod;
import cn.tzq0301.webserver.http.HttpResponse;

public interface Servlet {
    HttpResponse handleGET(HttpRequest request);
    HttpResponse handlePOST(HttpRequest request);

    default HttpResponse handlePUT(HttpRequest request) {
        return null;
    }

    default HttpResponse handleDELETE(HttpRequest request) {
        return null;
    }

    default HttpResponse handlePATCH(HttpRequest request) {
        return null;
    }

    default HttpResponse handleHEAD(HttpRequest request) {
        return null;
    }

    default HttpResponse handleTRACE(HttpRequest request) {
        return null;
    }

    default HttpResponse handleOPTIONS(HttpRequest request) {
        return null;
    }

    default HttpResponse handleCONNECT(HttpRequest request) {
        return null;
    }


    default HttpResponse handle(HttpRequest request, HttpRequestMethod method) {
        HttpResponse response;
        switch (method) {
            case GET:
                response = handleGET(request);
                break;
            case POST:
                response = handlePOST(request);
                break;
            case PUT:
                response = handlePUT(request);
                break;
            case DELETE:
                response = handleDELETE(request);
                break;
            case PATCH:
                response = handlePATCH(request);
                break;
            case HEAD:
                response = handleHEAD(request);
                break;
            case TRACE:
                response = handleTRACE(request);
                break;
            case OPTIONS:
                response = handleOPTIONS(request);
                break;
            case CONNECT:
                response = handleCONNECT(request);
                break;
            default:
                response = null;
                break;
        }
        return response;
    }
}
