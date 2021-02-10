package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingCar;
import racingcar.domain.TryCount;
import racingcar.utils.RacingCarUtils;
import racingcar.view.RacingCarView;
import racingcar.view.io.InputView;

import java.util.List;

public class RacingCarController {
    public void run() {
        RacingCar racingCar = setUpRacingCar();
        racingCar.start();
        RacingCarView.printFinalResult(racingCar.calculateResult());
    }

    private RacingCar setUpRacingCar() {
        List<String> carNames = RacingCarUtils.splitInputString(InputView.getCarNameInput());
        Cars cars = new Cars(carNames);
        TryCount tryCount = new TryCount(InputView.getTryCountInput());
        return new RacingCar(cars, tryCount);
    }
}
