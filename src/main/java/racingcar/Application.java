package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.splitter.NameSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Application.java
 * 시작 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class Application {
    public static void main(String[] args) {
        String rawCarNames = InputView.inputCarNames();
        Cars cars = new Cars(NameSplitter.split(rawCarNames));
        int numberOfRound = InputView.inputNumberOfRound();
        Round round = new Round(numberOfRound);
        OutputView.printGameResultMessage();
        for (int i = 0; i < round.getNumberOfRound(); i++) {
            cars.run();
            OutputView.printRoundResult(cars);
        }
        OutputView.printWinner(cars.findWinner());
    }
}
