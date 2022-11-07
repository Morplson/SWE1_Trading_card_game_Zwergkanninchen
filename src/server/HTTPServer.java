package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer implements Runnable{

    // port to listen connection
    private static final int PORT = 8080;

    private static ServerSocket listener = null;



    public static void main(String[] args) {
        System.out.println("start server");

        try {
            listener = new ServerSocket(PORT, 5);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new HTTPServer()));

        try {
            while (true) {
                Socket s = listener.accept();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                System.out.println("srv: sending welcome message");
                writer.write("Welcome to myserver!");
                writer.newLine();
                writer.write("Please enter your commands...");
                writer.newLine();
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String message;
                do {
                    message = reader.readLine();
                    System.out.println("srv: received: " + message);
                } while (!"quit".equals(message));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            listener.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        listener = null;
        System.out.println("close server");
    }
}
