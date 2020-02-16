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

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.CarNames;
import racingcar.domain.RacingResults;
import racingcar.domain.TryCount;
import racingcar.controller.Racing;
import racingcar.controller.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {

        CarNames carNames = inputCarNames();
        Cars cars = new Cars(carNames);
        TryCount tryCount = inputTryCount();

        RacingResults racingProgress = Racing.run(cars, tryCount);
        OutputView.printExecutionResult();
        OutputView.printResultFactory(racingProgress);

        List<String> winners = Winner.getWinners(cars);
        OutputView.printWinner(winners);
    }


    private static CarNames inputCarNames() {
        while (true) {
            try {
                OutputView.printInputCarNames();
                String carName = InputView.input();
                return new CarNames(carName);
            } catch (IllegalArgumentException ioe) {
                OutputView.printString(ioe.getMessage());
            }
        }
    }

    private static TryCount inputTryCount() {
        while (true) {
            try {
                OutputView.printInputTryCount();
                String count = InputView.input();
                return new TryCount(count);
            } catch (Exception e) {
                OutputView.printString(e.getMessage());
            }
        }
    }
}
