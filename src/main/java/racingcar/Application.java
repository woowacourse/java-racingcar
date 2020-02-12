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
import racingcar.domain.CarNames;
import racingcar.domain.Controller;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int tryCount = inputTryCount();
        Controller controller = new Controller(carNames, tryCount);

        String racingProgress = controller.run();
        OutputView.printExecutionResult();
        OutputView.printString(racingProgress);

        String winner = controller.getWinner();
        OutputView.printWinner(winner);
    }

    private static List<String> inputCarNames() {
        while (true) {
            try {
                OutputView.printInputCarNames();
                String carName = InputView.input();
                CarNames carNames = new CarNames(carName);
                return carNames.getCarNames();
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
