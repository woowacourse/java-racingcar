package controller;

import domain.Cars;
import domain.ErrorMessage;
import domain.RacingCarGame;
import view.InputView;
import view.OutputView;

public class RacingCarController {
    public static final int MINIMUM_ATTEMPT_LIMIT = 1;
    private final RacingCarGame service;
    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController(RacingCarGame service, OutputView outputView, InputView inputView) {
        this.service = service;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        inputCarName();
        service.playGame(inputAttemptLimit());
        outputView.printWinners(service.getWinnerName());
    }

    private Cars inputCarName() {
        try {
            String inputCarName = inputView.requestCarName();
            return service.setCars(service.separateCarName(inputCarName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
        if (inputAttemptLimit < MINIMUM_ATTEMPT_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.POSITIVE_NUMBER_REQUIRED.getMessage());
        }
    }
}
