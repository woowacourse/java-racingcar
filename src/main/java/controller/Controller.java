package controller;

import domain.Car;
import domain.Service;
import java.util.List;
import java.util.Scanner;
import view.InputView;

public class Controller {
    private Service service;
    public Controller(Service service) {
        this.service = service;
    }

    public void run() {
        String inputCarName = inputCarName();
        inputAttemptLimit();
        service.setCars(service.separateCarName(inputCarName));
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
