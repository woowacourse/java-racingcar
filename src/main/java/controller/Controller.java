package controller;

import java.util.Scanner;
import view.InputView;

public class Controller {
    public Controller() {
    }

    public void run() {
        inputCarName();
        inputAttemptLimit();
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
