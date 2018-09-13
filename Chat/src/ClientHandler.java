import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
    //    private Socket socket;
    private Server server;
    private PrintWriter pw;
    private Scanner sc;
    private String nick;

    public ClientHandler(Socket socket, Server server) {
//        this.socket = socket;
        this.server = server;

        try {
            sc = new Scanner(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream(), true);
            new Thread(() -> {
                auth();
                System.out.println(nick + " handler waiting for new massages");
                while (socket.isConnected()) {
                    String s = sc.nextLine();
                    if (s != null && s.equals("/exit"))
                        server.unsubscribe(this);
                    if (s != null && s.startsWith("/w ")) {
                        int msgStartFrom = 3 + s.substring(3).indexOf(" ");
                        String nikeTo = s.substring(3,msgStartFrom);
                        server.sendPrivateMessage(nick + " >> " + nikeTo + " : "+ s.substring(msgStartFrom), nick, nikeTo);
                    } else if (s != null && !s.isEmpty())
                        server.sendBroadcastMessage(nick + " : " + s);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void auth() {
        while (true) {
            if (!sc.hasNextLine()) continue;
            String s = sc.nextLine();
            if (s.startsWith("/auth")) {
                String[] commands = s.split(" ");// /auth login1 pass1
                if (commands.length >= 3) {
                    String login = commands[1];
                    String password = commands[2];
                    System.out.println("Try to login with " + login + " and " + password);
                    String nick = server.getAuthService()
                            .authByLoginAndPassword(login, password);
                    if (nick == null) {
                        String msg = "Invalid login or password";
                        System.out.println(msg);
                        pw.println(msg);
                    } else if (server.isNickTaken(nick)) {
                        String msg = "Nick " + nick + " already taken!";
                        System.out.println(msg);
                        pw.println(msg);
                    } else {
                        this.nick = nick;
                        String msg = "Auth ok!";
                        System.out.println(msg);
                        pw.println(msg);
                        server.subscribe(this);
                        break;
                    }
                }
            } else {
                pw.println("Invalid command!");
            }
        }
    }

    public void sendMessage(String msg) {
        pw.println(msg);
    }

    public String getNick() {
        return nick;
    }
}