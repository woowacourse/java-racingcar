package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    public static void playGame() {
        CarProcessing carProcessing = new CarProcessing();
        CarNames carNames = InputView.InputCarNames();
        List<Car> cars = carProcessing.createCar(carNames.getName());
        TryCount tryCount = InputView.InputRacingTryCount();

        OutputView.printRacingResultTitle();
        for (int i = 0; i < tryCount.getCount(); i++) {
            carProcessing.race();
            OutputView.printRacingResult(cars);
        }
        OutputView.printWinner(new RacingResult(cars));
    }

}