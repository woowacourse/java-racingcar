package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Trial;
import racingcar.domain.Winners;
import racingcar.view.RacingCarView;
import utils.RandomUtils;

public class RacingCarController {

    private static final int MINIMUM_RANDOM_RPM = 0;
    private static final int MAXIMUM_RANDOM_RPM = 9;
    private Cars cars;
    private Trial trial;

    public void race() {
        prepareCars();
        prepareTrial();
        play();
        finish();
    }

    private void prepareCars() {
        String input = RacingCarView.requestCars();
        cars = new Cars(input);
    }

    private void prepareTrial() {
        String input = RacingCarView.requestTrial();
        trial = new Trial(input);
    }

    private void play() {
        RacingCarView.printNewLine();
        RacingCarView.printResult();
        raceByTrial();
    }

    private void raceByTrial() {
        for (int t = 0; t < trial.getTrial(); t++) {
            raceByCar();
        }
    }

    private void raceByCar() {
        for (Car car : cars.getCars()) {
            int currentRpm = RandomUtils.nextInt(MINIMUM_RANDOM_RPM, MAXIMUM_RANDOM_RPM);
            car.move(currentRpm);
            RacingCarView.printCarPosition(car);
        }
        RacingCarView.printNewLine();
    }

    private void finish() {
        cars.findMaxPosition();
        Winners winners = new Winners(cars.getCars(), cars.getMaxPosition());
        RacingCarView.printWinners(winners.getWinners());
    }
}
