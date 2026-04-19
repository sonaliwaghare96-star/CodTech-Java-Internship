import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    // Store all connected clients
    static List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) {

        try {
            // STEP 1: Create server socket on port 5000
            ServerSocket serverSocket = new ServerSocket(7000);
            System.out.println("Server started... Waiting for clients");

            // STEP 2: Keep accepting clients forever
            while (true) {

                Socket socket = serverSocket.accept(); // client connected
                System.out.println("Client connected");

                // STEP 3: Output stream for sending messages to client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Add client to list
                clientWriters.add(out);

                // STEP 4: Start new thread for this client
                Thread t = new ClientHandler(socket, out);
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // THREAD CLASS for handling each client
    static class ClientHandler extends Thread {

        Socket socket;
        PrintWriter out;
        BufferedReader in;

        ClientHandler(Socket socket, PrintWriter out) {
            this.socket = socket;
            this.out = out;
        }

        public void run() {
            try {
                // STEP 5: Read messages from client
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String msg;

                while ((msg = in.readLine()) != null) {

                    System.out.println("Client says: " + msg);

                    // STEP 6: Broadcast message to ALL clients
                    for (PrintWriter writer : clientWriters) {
                        writer.println(msg);
                    }
                }

            } catch (Exception e) {
                System.out.println("Client disconnected");
            }
        }
    }
}