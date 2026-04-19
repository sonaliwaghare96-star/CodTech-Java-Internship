import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        try {
            // STEP 1: Connect to server
            Socket socket = new Socket("localhost", 5000);

            // STEP 2: Output stream (send messages)
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // STEP 3: Input stream (receive messages)
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // STEP 4: Thread to continuously read messages
            Thread readThread = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Server: " + msg);
                    }
                } catch (Exception e) {
                    System.out.println("Connection closed");
                }
            });

            readThread.start();

            // STEP 5: Send messages
            Scanner sc = new Scanner(System.in);
            String message;

            System.out.println("Start chatting...");

            while (true) {
                message = sc.nextLine();
                out.println(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}