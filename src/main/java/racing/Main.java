/*
 * @(#)Main.java
 *
 * v 2.0.0
 *
 * 2019.05.11
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing;

import java.util.List;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

/**
 * 레이싱 게임을 진행하는 컨트롤러 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 2.0.0
 * @see InputView
 * @see RacingGame
 */
public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Car> cars = getCars(inputView);
        int runs = getRuns(inputView);
        runRacingGame(runs, new RacingGame(cars));
    }

    private static List<Car> getCars(InputView inputView) {
        OutputView.printMessageCarNames();
        return inputView.getCarNames();
    }

    private static int getRuns(InputView inputView) {
        OutputView.printMessageRuns();
        return inputView.getRuns();
    }

    private static void runRacingGame(int runs, RacingGame racingGame) {
        OutputView.printResultTitle();
        for (int i = 0; i < runs; i++) {
            racingGame.runEachGame();
            OutputView.printEachGameResult(racingGame);
        }
        OutputView.printResultTotal(racingGame);
    }
}
