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

        List<Name> inputNames = InputView.inputNames(scanner);
        Cars cars = Cars.createByNames(inputNames);
        Rounds rounds = InputView.inputRounds(scanner);

        RacingGame racingGame = new RacingGame(cars, rounds);

        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printResults(racingGame.getRaceResults());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
