package view;

import domain.TryCount;
import dto.request.CarNameDto;

import java.util.List;

public class InputViewProxy extends InputView {

    private final InputView inputView;

    public InputViewProxy(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public List<CarNameDto> sendCarsName() {
        try {
            return inputView.sendCarsName();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return sendCarsName();
        }
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

    private void printExceptionMessage(String message) {
        System.out.println("[ERROR] " +message);
    }
}



