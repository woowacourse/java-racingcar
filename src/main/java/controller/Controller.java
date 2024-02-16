package controller;

import conversion.Converter;
import domain.Car;
import java.util.List;
import service.Service;
import view.InputView;
import view.IterativeReader;
import view.OutputView;

public class Controller {

    public static void start() {
        List<Car> cars = IterativeReader.readUntilNoError(Controller::findCars);
        int round = IterativeReader.readUntilNoError(Controller::findRound);

        OutputView.printRoundResult();

        for (int i = 0; i < round; i++) {
            Service.playOneRound(cars);
            OutputView.printScore(cars);
        }

        List<String> winnerNames = Service.getWinnerNames(cars);
        OutputView.printWinners(winnerNames);
    }

    private static List<Car> findCars() {
        OutputView.printCarNames();
        String rawCarNames = InputView.read();
        return Converter.toCars(rawCarNames);
    }

    private static int findRound() {
        OutputView.printRound();
        String rawRound = InputView.read();
        return Converter.toRound(rawRound);
    }
}
