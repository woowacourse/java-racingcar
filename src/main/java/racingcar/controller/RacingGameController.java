package racingcar.controller;

import java.util.List;
import racingcar.view.RacingGameView;
import racingcar.domain.Car;
import racingcar.utils.ParsingUtils;
import racingcar.utils.WinnerUtils;
import utils.RandomUtils;

public class RacingGameController {

    private static final int MINIMUM_RANDOM_RPM = 0;
    private static final int MAXIMUM_RANDOM_RPM = 9;

    private List<Car> cars;
    private int trial;

    public void play() {
        prepare();
        race();
        finish();
    }

    private void prepare() {
        String input = RacingGameView.requestCars();
        cars = ParsingUtils.parseCarNames(input);

        input = RacingGameView.requestTrial();
        trial = ParsingUtils.parseTrial(input);
    }

    private void race() {
        RacingGameView.printNewLine();
        RacingGameView.printResult();
        raceByTrial();
    }

    private void raceByTrial() {
        for (int t = 0; t < trial; t++) {
            raceByCar();
        }
    }

    private void raceByCar() {
        for (Car car : cars) {
            int currentRpm = RandomUtils.nextNumber();
            car.tryToMove(currentRpm);
            RacingGameView.printCarPosition(car);
        }
        RacingGameView.printNewLine();
    }

    private void finish() {
        List<String> winnerNames = WinnerUtils.findWinners(cars);
        RacingGameView.printWinners(winnerNames);
    }
}
