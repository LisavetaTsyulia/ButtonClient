package control;

import java.io.BufferedReader;

public class CheckNewNumThread extends Thread {
    private BufferedReader reader;
    private boolean isAlive;
    private Controller controller;

    public CheckNewNumThread(BufferedReader reader, Controller controller) {
        isAlive = true;
        this.reader = reader;
        this.controller = controller;
    }

    @Override
    public void run() {
        super.run();
        String line;
        while(isAlive) {
            try {
                line = reader.readLine();
                if (! line.equals("")) {
                    controller.changeCounterLbl(line);
                }
            }catch (Exception ex) {
                ex.printStackTrace();
                isAlive = false;
            }
        }
    }
}
