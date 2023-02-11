package view;

import domain.TryCount;
import dto.request.CarNameDto;

import java.util.InputMismatchException;
import java.util.List;

public class InputViewForRetry {

    private InputView inputView;

    public List<CarNameDto> sendCarsName(InputView inputView) {
        this.inputView = inputView;
        try {
            return this.inputView.sendCarsName();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return sendCarsName(inputView);
        }
    }

    public TryCount sendTryCount(InputView inputView) {
        this.inputView = inputView;
        try {
            return this.inputView.sendTryCount();
        } catch (InputMismatchException exception) {
            printExceptionMessage("시도 횟수는 양의 정수여야 합니다.");
            return sendTryCount(inputView);
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return sendTryCount(inputView);
        }
    }

    private void printExceptionMessage(String message) {
        System.out.println("[ERROR] " +message);
    }
}