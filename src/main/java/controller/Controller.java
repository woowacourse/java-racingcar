package controller;

import domain.Car;
import domain.Service;
import java.util.List;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Controller {
    private final Service service;
    private final Scanner scanner = new Scanner(System.in);

    public Controller(Service service) {
        this.service = service;
    }

    public void run() {
        List<Car> cars = inputCarName();
        int inputAttemptLimit = inputValue();
        service.playGame(cars, inputAttemptLimit);
        List<String> winners = service.getWinner(cars, service.getMaxPosition(cars));
        OutputView.printWinners(winners);
    }

    private List<Car> inputCarName() {
        try {
            InputView.requestCarName();
            return service.setCars(service.separateCarName(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputCarName();
        }
    }

    private int inputValue() {
        InputView.requestAttemptLimit();
        return validateNum(scanner.nextLine());
    }

    private int validateNum(String inputValue) {
        try {
            int inputAttemptLimit = validateInputAttemptLimit(inputValue);
            validateNumber(inputAttemptLimit);
            return inputAttemptLimit;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputValue();
        }
    }

    public int validateInputAttemptLimit(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }

    public void validateNumber(int inputAttemptLimit) {
        if (inputAttemptLimit <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 양수여야 합니다.");
        }
    }
}
