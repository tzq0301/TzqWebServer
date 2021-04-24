package cn.tzq0301.webserver.thread;

import cn.tzq0301.webserver.handler.Dispatcher;
import cn.tzq0301.webserver.http.HttpResponse;
import cn.tzq0301.webserver.resolver.HttpRequestResolver;
import cn.tzq0301.webserver.http.HttpRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author TZQ
 * @Description TODO
 */
public class HttpHandlerThread implements Runnable {
    private final Socket socket;

    public HttpHandlerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (final InputStream inputStream = socket.getInputStream();
             final OutputStream outputStream = socket.getOutputStream()) {
            byte[] bytes = new byte[1024 * 16];
            int len = inputStream.read(bytes);

            final HttpRequest httpRequest = HttpRequestResolver.resolve(bytes, len);

            final HttpResponse httpResponse = Dispatcher.handle(httpRequest);

            outputStream.write(httpResponse.toMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                while (!socket.isInputShutdown() || !socket.isOutputShutdown()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
