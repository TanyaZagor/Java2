import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket serv = null;
        Socket socket = null;
        try {
            serv = new ServerSocket(8189);
            socket = serv.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Thread clientThread = new Thread(() -> {
                try {
                    while (true) {
                        if (scanner.hasNext()) {
                            String str = scanner.nextLine();
                            if (str.equals("end")) break;
                            System.out.println(str);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            clientThread.start();

            Scanner sc = new Scanner(System.in);

            while (clientThread.isAlive()) {
                String str = sc.nextLine();
                if (str.equals("end")) break;
                printWriter.println(str);
                printWriter.flush();
            }


        } catch (IOException e) {
            System.out.println("Exception");
        } finally {
            try {
                socket.close();
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
