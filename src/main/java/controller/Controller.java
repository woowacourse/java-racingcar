package controller;

import domain.Car;
import domain.Service;
import java.util.List;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Controller {
    private final Service service;
    private final OutputView outputView;
    private final InputView inputView;
    private final Scanner scanner = new Scanner(System.in);

    public Controller(Service service, OutputView outputView, InputView inputView) {
        this.service = service;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        inputCarName();
        int inputAttemptLimit = inputValue();
        service.playGame(inputAttemptLimit);
        List<String> winners = service.getWinnerName();
        outputView.printWinners(winners);
    }

    private List<Car> inputCarName() {
        try {
            inputView.requestCarName();
            return service.setCars(service.separateCarName(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputCarName();
        }
    }

    private int inputValue() {
        inputView.requestAttemptLimit();
        return validateNum(scanner.nextLine());
    }

    private int validateNum(String inputValue) {
        try {
            int inputAttemptLimit = validateInputAttemptLimit(inputValue);
            validateNumber(inputAttemptLimit);
            return inputAttemptLimit;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputValue();
        }
    }

    public int validateInputAttemptLimit(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수여야 합니다.");
        }
    }

    public void validateNumber(int inputAttemptLimit) {
        if (inputAttemptLimit <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 양수여야 합니다.");
        }
    }
}
