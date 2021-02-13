package racingcar.controller;

import javafx.util.Pair;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Trial;
import racingcar.view.RacingCarView;

public class RacingCarController {

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
        for (Pair<String, Integer> car : cars.racing()) {
            RacingCarView.printCarPosition(car);
        }
        RacingCarView.printNewLine();
    }

    private void finish() {
        cars.findMaxPosition();
        RacingCarView.printWinners(cars.findWinner());
    }
}
