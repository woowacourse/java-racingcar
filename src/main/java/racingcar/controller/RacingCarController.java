package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.utils.RacingCarUtils;
import racingcar.view.RacingCarView;
import racingcar.view.io.InputView;

public class RacingCarController {
    public void run() {
        RacingCar racingCar = setUpRacingCar();
        racingCar.start();
        RacingCarView.printFinalResult(racingCar.calculateResult());
    }

    private RacingCar setUpRacingCar() {
        Cars cars = new Cars(RacingCarUtils.splitInputString(InputView.getCarNameInput()));
        TryCount tryCount = new TryCount(InputView.getTryCountInput());
        return new RacingCar(cars, tryCount);
    }
}
