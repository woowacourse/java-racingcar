package racingcar;

import racingcar.controller.CarController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.utils.RacingCarUtils;
import racingcar.view.RacingCarView;
import racingcar.view.io.InputView;

public class RacingCar {
    private Cars cars;
    private TryCount tryCount;

    public void run() {
        setUpRacingCar();
        selectWinners();
        RacingCarView.printFinalResult(selectWinners());
    }

    private void setUpRacingCar() {
        cars = new Cars(RacingCarUtils.splitInputString(InputView.getCarNameInput()));
        tryCount = new TryCount(InputView.getTryCountInput());
        progressTryCount();
    }

    private void progressTryCount() {
        for (int i = 0; i < tryCount.getCount(); i++) {
            progressRacing();
            RacingCarView.printProgressResult(cars.cars());
        }
    }

    private void progressRacing() {
        for (Car car : cars.cars()) {
            CarController carController = new CarController(car);
            carController.moveCar();
        }
    }

    private Winners selectWinners() {
        Winners winners = new Winners(cars);
        return winners;
    }
}
