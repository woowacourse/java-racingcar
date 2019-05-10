package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {


    static List<Car> cars = null;

    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar();

        CarNames carNames = InputView.InputCarNames();
        cars = racingCar.createCar(carNames.getName());
        TryCount tryCount = InputView.InputRacingTryCount();

        OutputView.printRacingResultTitle();
        for (int i = 0; i < tryCount.getCount(); i++) {
            racingCar.race();
            OutputView.printRacingResult(cars);
        }
        OutputView.printWinner(new RacingResult(cars));
    }

}
