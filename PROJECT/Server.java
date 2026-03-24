import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create server socket
            ServerSocket ss = new ServerSocket(12345);
            System.out.println("Server started... Waiting for client");

            // Accept client connection
            Socket s = ss.accept();
            System.out.println("Client connected");

            // Input and Output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            BufferedReader sc = new BufferedReader(
                    new InputStreamReader(System.in));

            String msg, reply;

            while (true) {
                msg = in.readLine();
                if (msg.equalsIgnoreCase("bye"))
                    break;

                System.out.println("Client: " + msg);

                System.out.print("Server: ");
                reply = sc.readLine();
                out.println(reply);
            }

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
