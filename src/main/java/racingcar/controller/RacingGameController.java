package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryNumber;
import racingcar.view.OutputView;

public class RacingGameController {

    public void play(final Cars cars, final TryNumber tryNumber) {
        OutputView.printPlayResultMessage();
        for (int i = 0; i < tryNumber.getValue(); i++) {
            cars.move();
            OutputView.printNewLine();
        }
        OutputView.printWinners(cars.getWinners());
    }

}