package controller;

import domain.Car;
import domain.Game;

import java.util.List;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Controller {
    Game game = new Game();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        List<Car> cars=setCarName();
        playGame(cars, setInputAttemptLimit());
        List<String> winners = game.getWinner(cars);
        OutputView.printWinners(winners);
    }

    private void playGame(List<Car> cars, int attemptLimit) {
        OutputView.printHeadLine();
        while (attemptLimit!=0) {
            game.playRacing(cars);
            OutputView.printResult(cars);
            attemptLimit--;
        }
    }

    private List<Car> setCarName() {
        try {
            InputView.requestCarName();
            return game.setCars(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return setCarName();
        }
    }

    private int setInputAttemptLimit() {
        InputView.requestAttemptLimit();
        try {
            return game.setAttemptLimit(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return setInputAttemptLimit();
        }
    }
}

