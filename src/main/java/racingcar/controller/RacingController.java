package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.PlayTime;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Cars cars;

    public RacingController() {
        this.inputView = new InputView();
        this.cars = new Cars();
        this.outputView = new OutputView();
    }

    public void start() {
        enrollCars();
        PlayTime playTime = new PlayTime(inputView.getPlayTimes());
        startRacing(playTime);
        showRacingResult();
    }

    private void enrollCars() {
        String[] carNames = inputView.getCarNames().split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.participateInRacing(car);
        }
    }

    private void startRacing(PlayTime playTime) {
        outputView.announceRacingStart();
        while (!playTime.isEnd()) {
            cars.race();
            playTime.decreasePlayTime();
            outputView.recordCurrentScore(cars);
        }
    }

    private void showRacingResult() {
        outputView.recordRacingWinners(cars.judgeRacingWinners());
    }
}
