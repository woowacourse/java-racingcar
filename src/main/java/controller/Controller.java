package controller;

import domain.Car;
import domain.Game;

import java.util.List;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Controller {
    Game game = new Game();

    public void run() {
        final var cars = InputView.requestCarName(game);
        final var attemptLimit = InputView.requestAttemptLimit(game);

        playGame(cars, attemptLimit);

        final var winners = game.getWinner(cars);

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
}
