package controller;

import conversion.Converter;
import domain.Car;
import java.util.List;
import service.Service;
import view.InputView;
import view.OutputView;

public class Controller {

    public static void start() {
        List<Car> cars = getCars();
        int round = getRound();

        OutputView.printRoundResult();

        for (int i = 0; i < round; i++) {
            Service.playOneRound(cars);
            OutputView.printScore(cars);
        }

        List<String> winnerNames = Service.getWinnerNames(cars);
        OutputView.printWinners(winnerNames);
    }

    private static int getRound() {
        OutputView.printRound();
        String rawRound = InputView.read();
        return Converter.toRound(rawRound);
    }

    private static List<Car> getCars() {
        OutputView.printCarNames();
        String rawCarNames = InputView.read();
        return Converter.toCars(rawCarNames);
    }
}
