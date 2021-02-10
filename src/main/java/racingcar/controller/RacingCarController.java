package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.RacingCar;
import racingcar.domain.TryCount;
import racingcar.utils.RacingCarUtils;
import racingcar.view.RacingCarView;
import racingcar.view.io.InputView;

import java.util.List;

public class RacingCarController {
    public void run() {
        RacingCar racingCar = setUpRacingCar();
        while (racingCar.isNotFinish()) {
            racingCar.start();
            RacingCarView.printNowProgressResult(racingCar);
        }
        RacingCarView.printFinalResult(racingCar.calculateResult());
    }

    private RacingCar setUpRacingCar() {
        List<Name> carNames = RacingCarUtils.splitInputString(InputView.getCarNameInput());
        Cars cars = Cars.makeFromCarNames(carNames);
        TryCount tryCount = new TryCount(InputView.getTryCountInput());
        return new RacingCar(cars, tryCount);
    }
}
