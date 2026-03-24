import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to server
            Socket s = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            BufferedReader sc = new BufferedReader(
                    new InputStreamReader(System.in));

            String msg, reply;

            while (true) {
                System.out.print("Client: ");
                msg = sc.readLine();
                out.println(msg);

                if (msg.equalsIgnoreCase("bye"))
                    break;

                reply = in.readLine();
                System.out.println("Server: " + reply);
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
