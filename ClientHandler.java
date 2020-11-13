package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String nickname;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    //цикл аутентификации
                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/")) {

                            if (str.startsWith("/auth ")) {
                                String[] token = str.split("\\s",3);
                                String newNick = server.getAuthService()
                                        .getNicknameByLoginAndPassword(token[1], token[2]);
                                if (newNick != null) {
                                    nickname = newNick;
                                    out.writeUTF("/authok "+nickname);
                                    server.subscribe(this);
                                    break;
                                } else {
                                    out.writeUTF("Неверный логин / пароль");
                                }
                            }
                        }
                    }

                    //Цикл работы
                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/")) {
                            if (str.startsWith("/w")) {
                                String [] token = str.split("\\s+", 3);
                                if (token.length<3) {
                                    continue;
                                }
                                server.privateMsg(this, token[1], token[2]);
                            }

                        if (str.equals("/end")) {
                                out.writeUTF("/end");
                                break;
                                }
                            } else {
                            server.broadcastMsg(this, str);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Client disconnected!");
                    server.unsubscribe(this);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg (String msg) {
        try {
            System.out.println("Клиент" + (this.nickname != null ? "" + this.nickname : "") + ":" + msg);
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickname() {
        return nickname;
    }

}
