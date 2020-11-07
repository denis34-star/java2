package ru.geekbrains.lesson61;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    // Открываемый порт сервера
    private static final int port = 8189;
    private String TEMPL_MSG = "The client '%d' sent me message : \n\t ";
    private String TEMPL_CONN = "The client '%d' closed the connection";

    private Socket socket;
    private int num;

    public Server() {}
    public  void setSocket(int num, Socket socket) {
//Определение значений
        this.num = num;
        this.socket = socket;
        // Установка deamon - потока
        setDaemon(true);
        /*
         * Определение стандартного приоритета главного потока
         * int java.lang.Thread.NORM_PRIORITY = 5-the default
         * priority that is assigned to a thread.
         */
        setPriority(NORM_PRIORITY);
        // Старт потока
        start();
    }
    public void run() {
        try {
     // Определяем входной и выходной потоки сокета
     // для обмена данными с клиентом

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream dis = new DataInputStream(sin);
            DataOutputStream dos = new DataOutputStream(sout);

            String line = null;
            while (true) {
     // Ожидание сообщения от клиента
                line = dis.readUTF();
                System.out.println(String.format(TEMPL_MSG, num) + line);
                System.out.println("I am sending it back");
    // Отсылаем клиенту обратно эту строку текста
                dos.writeUTF("server receive text : " + line);
    // Завершаем передачу данных
                dos.flush();
                System.out.println();
                if (line.equalsIgnoreCase("quit")) {
     // Завершаем соединение
                    socket.close();
                    System.out.println(String.format(TEMPL_CONN, num));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        }
    }

    public static void main (String[] args) {
        ServerSocket srvSocket = null;
        try {
            try {
                int i = 0;
     // Счетчик подключений
     // Подключение сокета к localhost
                InetAddress ia;
                ia = InetAddress.getByName("localhost");
                System.out.println("Server started\n\n");
                while (true) {
      // Ожидание подключения
                    Socket socket= srvSocket.accept();
                    System.err.println("Client accepted");
    //Стартуем обработку клиента в отдельном потоке

                    new Server().setSocket(i++, socket);
                }
            } catch (Exception e) {
                System.out.println("Exception : " + e);

            }
        } finally {
            try {
                if (srvSocket != null)
                    srvSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.exit(0);

    }
}


