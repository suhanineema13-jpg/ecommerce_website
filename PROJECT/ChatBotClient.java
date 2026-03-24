import java.net.*;
import java.io.*;

public class ChatBotClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 12345);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("You: ");
                String q = sc.readLine();
                out.println(q);

                String ans = in.readLine();
                System.out.println("Bot: " + ans);

                if (q != null && q.trim().equalsIgnoreCase("bye")) break;
            }

            s.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
