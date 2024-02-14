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
        int inputAttemptLimit = inputAttemptLimit();
        List<Car> cars = service.setCars(service.separateCarName(inputCarName));
        service.playGame(cars,inputAttemptLimit);

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
}
