import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final static String SERVER_ADDR = "localhost";
    private final static int SERVER_PORT = 8189;

    private static Socket socket = null;
    private static Scanner in = null;
    private static PrintWriter out;
    private static Scanner scanner;

    public Client(){
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread serverThread = new Thread(() -> {
            try {
                while (true) {
                    if (in.hasNext()) {
                        String str = in.nextLine();
                        if (str.equals("end")) break;
                        System.out.println(str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
        sendMessages();
    }
    public static void main(String[] args) {
        Client client = new Client();

    }

    public void sendMessages () {
        String message;
        scanner = new Scanner(System.in);
        while (true) {
            message = scanner.nextLine();
            if (message.equals("end")) break;
            out.println(message);
            out.flush();
        }
        try {
            scanner.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}