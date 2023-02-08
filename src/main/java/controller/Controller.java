package controller;

import view.InputView;
import view.MessageView;

public class Controller {
    private final InputView inputView = new InputView();
    private final MessageView messageView = new MessageView();
    public void run(){
        messageView.printCarNameMessage();
        inputView.inputCarName();
    }
}
