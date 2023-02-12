package view;

import domain.Name;
import domain.TryCount;

import java.util.List;

//TODO: ExceptionHandler 할용하도록 리팩토링
public class InputViewProxy extends InputView {

    private final InputView inputView;

    public InputViewProxy(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public List<Name> sendCarsName() {
        try {
            return inputView.sendCarsName();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return sendCarsName();
        }
    }

    private void printExceptionMessage(String message) {
        System.out.println("[ERROR] " +message);
    }

    @Override
    public TryCount sendTryCount() {
        try {
            return inputView.sendTryCount();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return sendTryCount();
        }
    }
}



