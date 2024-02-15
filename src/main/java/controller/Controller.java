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
        String inputCarName = inputCarName();
        List<Car> cars = service.setCars(service.separateCarName(inputCarName));
        int inputAttemptLimit = inputAttemptLimit();
        validateNumber(inputAttemptLimit);
        service.playGame(cars, inputAttemptLimit);
        List<String> winners = service.getWinner(cars, service.getMaxPosition(cars));
        OutputView.printWinners(winners);
    }

    private String inputCarName() {
        InputView.requestCarName();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int inputAttemptLimit() {
        InputView.requestAttemptLimit();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void validateNumber(int inputAttemptLimit) {
        if (inputAttemptLimit <= 0) {
            throw new IllegalArgumentException();
        }
    }
}