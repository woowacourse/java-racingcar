/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        11 Feb 2020
 *
 */

package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = inputCarNames();
        int tryCount = inputTryCount();
        RacingGame racingGame = new RacingGame(cars, tryCount);

        OutputView.printExecutionResult();
        racingGame.getRacingProgress();

        String winner = racingGame.getWinner();
        OutputView.printWinner(winner);
    }

    private static Cars inputCarNames() {
        while (true) {
            try {
                OutputView.printInputCarNames();
                String carName = InputView.input();
                return new Cars(carName);
            } catch (IllegalArgumentException ioe) {
                OutputView.printString(ioe.getMessage());
            }
        }
    }

    private static int inputTryCount() {
        while (true) {
            try {
                OutputView.printInputTryCount();
                String count = InputView.input();
                TryCount tryCount = new TryCount(count);
                return tryCount.getTryCount();
            } catch (Exception e) {
                OutputView.printString(e.getMessage());
            }
        }
    }
}
