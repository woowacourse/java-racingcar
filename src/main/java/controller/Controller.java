package controller;

import conversion.Converter;
import domain.Car;
import java.util.List;

import domain.RacingGame;
import domain.RandomMoveStrategy;
import view.InputView;
import view.IterativeReader;
import view.OutputView;

public class Controller {

    public static void start() {
        List<Car> cars = IterativeReader.readUntilNoError(Controller::getCars);
        int round = IterativeReader.readUntilNoError(Controller::getRound);

        OutputView.printRoundResult();

        for (int i = 0; i < round; i++) {
            RacingGame.playOneRound(cars, new RandomMoveStrategy());
            OutputView.printScore(cars);
        }

        List<String> winnerNames = RacingGame.getWinnerNames(cars);
        OutputView.printWinners(winnerNames);
    }

    private static List<Car> getCars() {
        OutputView.printCarNames();
        String rawCarNames = InputView.read();
        return Converter.toCars(rawCarNames);
    }

    private static int getRound() {
        OutputView.printRound();
        String rawRound = InputView.read();
        return Converter.toRound(rawRound);
    }
}
