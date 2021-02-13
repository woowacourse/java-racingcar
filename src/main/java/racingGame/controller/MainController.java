package racingGame.controller;

import racingGame.domain.racingCar.Cars;
import racingGame.domain.game.RacingGame;
import racingGame.domain.racingCar.Name;
import racingGame.domain.game.Rounds;
import racingGame.view.InputView;
import racingGame.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<Name> inputNames = InputView.inputNames(scanner);
        final Cars cars = Cars.createByNames(inputNames);
        final Rounds rounds = InputView.inputRounds(scanner);

        final RacingGame racingGame = new RacingGame(cars, rounds);

        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printResults(racingGame.getRaceResults());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
