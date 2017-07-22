package control;

import client.Client;
import javafx.scene.control.Label;

public class Controller {
    private Client client;
    private Label counterLbl = null;

    public void setClient(Client client) {
        this.client = client;
    }

    public void pushButton() {
        client.buttonPlus();
    }

    public void changeCounterLbl(String curNum) {
        if (counterLbl != null)
            counterLbl.setText(curNum);
    }

    public void setCounterLbl(Label counterLbl) {
        this.counterLbl = counterLbl;
    }
}
