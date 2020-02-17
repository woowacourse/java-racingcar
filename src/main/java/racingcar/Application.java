package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.domain.Winner;
import racingcar.splitter.NameSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        try {
            Cars cars = new Cars(InputView.inputCarNames());
            Round round = new Round(InputView.inputNumberOfRound());
            playGame(cars, round);
            Winner winner = new Winner(cars.findWinner());
            OutputView.printWinner(winner);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void playGame(Cars cars, Round round) {
        OutputView.printGameResultMessage();
        while (!round.isNotFinalRound()) {
            cars.run();
            OutputView.printRoundResult(cars);
            round.goNextRound();
        }
    }
}