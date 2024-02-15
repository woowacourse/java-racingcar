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

        // TODO: 이 부분을 Service로 옮겼으면 좋겠다
        for (int i = 0; i < round; i++) {
            Service.playOneRound(cars);
            OutputView.printScore(cars);
        }

        List<String> winnerNames = Service.getWinnerNames(cars);
        OutputView.printWinners(winnerNames);
    }
}
