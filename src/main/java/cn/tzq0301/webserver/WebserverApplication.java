package cn.tzq0301.webserver;

import cn.tzq0301.webserver.thread.HttpHandlerThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class WebserverApplication {
    private final ExecutorService exec = Executors.newCachedThreadPool();

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                final Socket socket = serverSocket.accept();
                exec.execute(new HttpHandlerThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(WebserverApplication.class, args);

        new WebserverApplication().run();
    }
}
