package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.*;
import racingcar.utils.RacingCarUtils;
import racingcar.view.RacingCarView;
import racingcar.view.io.InputView;

public class RacingCar {
    private Cars cars;
    private TryCount tryCount;

    public void run() {
        setUpRacingCar();
        selectWinners();
        RacingCarView.printFinalResult(selectWinners().getWinnersNames());
    }

    private void setUpRacingCar() {
        cars = new Cars(RacingCarUtils.splitInputString(InputView.getCarNameInput()));
        tryCount = new TryCount(InputView.getTryCountInput());
        GameRule gameRule = new GameRule();
        progressTryCount(gameRule);
    }

    private void progressTryCount(final GameRule gameRule) {
        for (int i = 0; i < tryCount.getCount(); i++) {
            progressRacing(gameRule);
            RacingCarView.printProgressResult(cars.cars());
        }
    }

    private void progressRacing(final GameRule gameRule) {
        for (Car car : cars.cars()) {
            moveMovableCar(car, gameRule);
        }
    }

    private void moveMovableCar(final Car car, final GameRule gameRule) {
        CarController carController = new CarController(car);
        RandomNumber randomNumber = new RandomNumber();
        if (gameRule.isMoveNumber(randomNumber.getNumber())) {
            carController.moveCar();
        }
    }

    private Winners selectWinners() {
        Winners winners = new Winners(cars);
        return winners;
    }
}
