import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
class ChatClient {
    public static void main(String[] args) throws IOException {
        // Create a socket to connect to the server
        Socket socket = new Socket("localhost", 1234);

        // Set up input and output streams for the client
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        // Thread to read messages from server
        Thread readMessage = new Thread(() -> {
            String msg;
            try {
                while ((msg = in.readLine()) != null) {
                    System.out.println("Server: " + msg);
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        });

        // Thread to send messages to the server
        Thread sendMessage = new Thread(() -> {
            String msg;
            while (true) {
                msg = scanner.nextLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("bye")) {
                    System.out.println("Exiting chat...");
                    break;
                }
            }
        });

        // Start both threads
        readMessage.start();
        sendMessage.start();
    }
}

// Server class
class ChatServer {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started. Waiting for a client...");

        // Wait for client connection
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        // Set up input and output streams for the server
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        // Thread to read messages from client
        Thread readMessage = new Thread(() -> {
            String msg;
            try {
                while ((msg = in.readLine()) != null) {
                    System.out.println("Client: " + msg);
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }
        });

        // Thread to send messages to the client
        Thread sendMessage = new Thread(() -> {
            String msg;
            while (true) {
                msg = scanner.nextLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("bye")) {
                    System.out.println("Exiting chat...");
                    break;
                }
            }
        });

        // Start both threads
        readMessage.start();
        sendMessage.start();
    }
}
