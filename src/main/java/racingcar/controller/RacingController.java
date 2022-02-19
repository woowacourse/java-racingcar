package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.PlayTime;
import racingcar.model.utils.RandomNumberGenerator;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class RacingController {

    public void start() {
        Cars cars = enrollCars();
        PlayTime playTime = new PlayTime(InputView.requestPlayTimes());
        Cars resultCars = startRacing(cars, playTime);
        showRacingResult(resultCars);
    }

    private Cars enrollCars() {
        List<Car> cars = new ArrayList<>();
        String[] carNames = InputView.requestCarNames();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }

    private Cars startRacing(Cars cars, PlayTime playTime) {
        OutputView.announceRacingStart();
        while (!playTime.isEnd()) {
            cars.race(new RandomNumberGenerator());
            playTime.decreasePlayTime();
            OutputView.recordCurrentScore(cars);
        }
        return cars;
    }

    private void showRacingResult(Cars resultCars) {
        OutputView.recordRacingWinners(resultCars.judgeRacingWinners());
    }
}
