package controller;

import domain.Car;
import domain.Service;
import java.util.List;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void run() {
        List<Car> cars = inputCarName();
        int inputAttemptLimit = inputAttemptLimit();
        validateNumber(inputAttemptLimit);
        service.playGame(cars, inputAttemptLimit);
        List<String> winners = service.getWinner(cars, service.getMaxPosition(cars));
        OutputView.printWinners(winners);
    }

    private List<Car> inputCarName() {
        try {
            InputView.requestCarName();
            Scanner scanner = new Scanner(System.in);
            return service.setCars(service.separateCarName(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputCarName();
        }

    }

    private int inputAttemptLimit() {
        try {
            InputView.requestAttemptLimit();
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputAttemptLimit();
        }
    }

    private void validateNumber(int inputAttemptLimit) {
        if (inputAttemptLimit <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 양수여야 합니다.");
        }
    }
}