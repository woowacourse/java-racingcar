package view;

import model.domain.TryCount;
import model.dto.request.CarNameDto;

import java.util.InputMismatchException;
import java.util.List;

public class InputViewNoRetry {

    private final InputView inputView;

    public InputViewNoRetry(InputView inputView) {
        this.inputView = inputView;
    }

    public List<CarNameDto> inputCarsName() {
        try {
            return inputView.inputCarsName();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
        }
        System.exit(0);
        return null;
    }

    public TryCount inputTryCount() {
        try {
            return inputView.inputTryCount();
        } catch (InputMismatchException exception) {
            printExceptionMessage("시도 횟수는 양의 정수여야 합니다.");
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
        }
        System.exit(0);
        return null;
    }

    private void printExceptionMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
