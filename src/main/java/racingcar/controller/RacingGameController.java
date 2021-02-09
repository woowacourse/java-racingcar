package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class RacingGameController {

    public void play(final Cars cars, final int tryNumber) {
        OutputView.printPlayResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            cars.move();
        }
        OutputView.printNewLine();
        OutputView.printWinners(cars.getWinners());
    }

}