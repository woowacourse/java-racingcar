package controller;

import domain.Car;
import domain.ErrorMessage;
import domain.Service;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Controller {
    private final Service service;
    private final OutputView outputView;
    private final InputView inputView;

    public Controller(Service service, OutputView outputView, InputView inputView) {
        this.service = service;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        inputCarName();
        service.playGame(inputAttemptLimit());
        List<String> winners = service.getWinnerName();
        outputView.printWinners(winners);
    }

    private List<Car> inputCarName() {
        try {
            String inputCarName = inputView.requestCarName();
            return service.setCars(service.separateCarName(inputCarName));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputCarName();
        }
    }

    private int inputAttemptLimit() {
        try {
            String inputAttemptLimit = inputView.requestAttemptLimit();
            int attemptLimit = validateInputAttemptLimit(inputAttemptLimit);
            validateNumber(attemptLimit);
            return attemptLimit;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputAttemptLimit();
        }
    }

    public int validateInputAttemptLimit(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_REQUIRED.getMessage());
        }
    }

    public void validateNumber(int inputAttemptLimit) {
        if (inputAttemptLimit <= 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_NUMBER_REQUIRED.getMessage());
        }
    }
}
