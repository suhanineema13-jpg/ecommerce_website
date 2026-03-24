import java.net.*;
import java.io.*;

public class ChatBotServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);
            System.out.println("ChatBot Server started...");

            Socket s = ss.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            while (true) {
                String q = in.readLine();
                if (q == null) break;

                q = q.toLowerCase();

                String ans;

                if (q.equals("bye")) {
                    ans = "Goodbye! Have a nice day 😊";
                    out.println(ans);
                    break;
                }
                else if (q.contains("hi") || q.contains("hello") || q.contains("hey")) {
                    ans = "Hello! I am a ChatBot. Ask me a general knowledge question.";
                }
                else if (q.contains("your name")) {
                    ans = "I am a simple ChatBot server.";
                }
                else if (q.contains("my name")) {
                    ans = "Your name is Suhani Neema.";
                }
                else if (q.contains("sap id") || q.contains("roll")) {
                    ans = "Your SAP ID / Roll Number is 70472300247.";
                }
                else if (q.contains("capital of india")) {
                    ans = "The capital of India is New Delhi.";
                }
                else if (q.contains("prime minister")) {
                    ans = "The Prime Minister of India is Narendra Modi.";
                }
                else if (q.contains("national animal")) {
                    ans = "The national animal of India is Tiger.";
                }
                else {
                    ans = "Sorry, I don't know the answer.";
                }

                out.println(ans);
            }

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
