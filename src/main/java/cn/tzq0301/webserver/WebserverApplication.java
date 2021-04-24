package cn.tzq0301.webserver;

import cn.tzq0301.webserver.thread.HttpHandlerThread;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class WebserverApplication implements CommandLineRunner {
    private final ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        SpringApplication.run(WebserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            for (;;) {
                final Socket socket = serverSocket.accept();
                exec.execute(new HttpHandlerThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
