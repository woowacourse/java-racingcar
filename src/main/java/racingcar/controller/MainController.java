package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Name;
import racingcar.domain.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        List<Name> carNames = InputView.receiveNames(scanner);
        Cars cars = Cars.createByNames(carNames);
        Rounds rounds = InputView.receiveRounds(scanner);

        RacingGame racingGame = new RacingGame(cars, rounds);

        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printResults(racingGame.getRaceResults());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
