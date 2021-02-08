package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.*;
import racingcar.utils.RacingCarUtils;
import racingcar.view.InputView;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCar {
    private Cars cars;
    private TryCount tryCount;

    public void run() {
        racingCarSetting();
        racing();
        pickWinners();
    }

    private void racingCarSetting() {
        cars = new Cars(getCarNames());
        tryCount = new TryCount(InputView.getTryCountInput());
    }

    private List<String> getCarNames() {
        return RacingCarUtils.splitInputString(InputView.getCarNameInput());
    }

    private void racing() {
        for (int i = 0; i < tryCount.getCount(); i++) {
            changeCarsStatus();
            RacingCarView.printProgressResult(cars.getCars());
        }
    }

    private void changeCarsStatus() {
        for (Car car : cars.getCars()) {
            moveMovableCar(car);
        }
    }

    private void moveMovableCar(final Car car) {
        CarController carController = new CarController(car);
        RandomNumber randomNumber = new RandomNumber();
        if (GameRule.isMoveNumber(randomNumber.getNumber())) {
            carController.carMove();
        }
    }

    private void pickWinners() {
        Winners winners = new Winners(cars);
        RacingCarView.printFinalResult(winners.getWinnersNames());
    }
}
