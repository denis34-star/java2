package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketTest extends Thread {
    private ServerSocket serverSocket;

    public SocketTest() throws IOException {
        serverSocket = new ServerSocket(8189);
        serverSocket.setSoTimeout(30000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port" + serverSocket.getLocalPort() + "...");
                Socket client = serverSocket.accept();
                System.out.println("Just connect to" + client.getRemoteSocketAddress());
                client.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    public static void main(String[] args) {
        try {
            Thread t = new SocketTest();
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
