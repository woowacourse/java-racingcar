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
            // TODO: List<Car>를 한 번에 처리할 Cars 클래스 만드는 것 고려
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
