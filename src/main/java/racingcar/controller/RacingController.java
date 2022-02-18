package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.PlayTime;
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
        Cars cars = new Cars();
        String[] carNames = InputView.requestCarNames().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.participateInRacing(car);
        }
        return cars;
    }

    private Cars startRacing(Cars cars, PlayTime playTime) {
        OutputView.announceRacingStart();
        while (!playTime.isEnd()) {
            cars.race();
            playTime.decreasePlayTime();
            OutputView.recordCurrentScore(cars);
        }
        return cars;
    }

    private void showRacingResult(Cars resultCars) {
        OutputView.recordRacingWinners(resultCars.judgeRacingWinners());
    }
}
