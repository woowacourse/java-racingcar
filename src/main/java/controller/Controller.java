package controller;

import conversion.Converter;
import domain.Car;
import java.util.List;
import service.Service;
import view.InputView;
import view.OutputView;

public class Controller {

    public static void start() {
        OutputView.printCarNames();
        String rawCarNames = InputView.read();
        List<Car> cars = Converter.toCars(rawCarNames);

        OutputView.printRound();
        String rawRound = InputView.read();
        int round = Converter.toRound(rawRound);

        OutputView.printRoundResult();

        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                Service.moveForward(car);
            }
            OutputView.printScore(cars);
            System.out.println();
        }

        List<String> winnerNames = Service.getWinnerNames(cars);
        OutputView.printWinners(winnerNames);
    }
}
