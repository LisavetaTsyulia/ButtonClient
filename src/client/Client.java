package client;

import control.CheckNewNumThread;
import control.Controller;
import gui.ClientWindow;

import java.io.*;
import java.net.*;

public class Client {
    private Socket clientSocket;
    private OutputStream outStream;
    private InputStream inputStream;
    private PrintWriter printWriter;
    private BufferedReader reader;
    public Controller controller;

    public Client(Controller controller){
        this.controller = controller;
        setConnection(controller);
    }

    private void setConnection(Controller controller){
        try {
            clientSocket = new Socket("192.168.1.7", 4444);
            outStream = clientSocket.getOutputStream();
            inputStream = clientSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            printWriter = new PrintWriter(outStream);
            new CheckNewNumThread(reader, controller).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buttonPlus() {
        printWriter.write('+');
        printWriter.flush();
    }

}
