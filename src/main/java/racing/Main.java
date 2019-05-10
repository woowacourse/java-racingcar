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
import racing.view.RacingView;

/**
 * 레이싱 게임을 진행하는 컨트롤러 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 2.0.0
 * @see RacingView
 * @see RacingGame
 */
public class Main {
    public static void main(String[] args) {
        RacingView racingView = new RacingView();
        List<Car> cars = getCars(racingView);
        int runs = getRuns(racingView);
        runRacingGame(racingView, runs, new RacingGame(cars));
    }

    private static List<Car> getCars(RacingView racingView) {
        racingView.printMessageCarNames();
        return racingView.getCarNames();
    }

    private static int getRuns(RacingView racingView) {
        racingView.printMessageRuns();
        return racingView.getRuns();
    }

    private static void runRacingGame(RacingView racingView, int runs, RacingGame racingGame) {
        racingView.printResultTitle();
        for (int i = 0; i < runs; i++) {
            racingGame.runEachGame();
            racingView.printEachGameResult(racingGame);
        }
        racingView.printResultTotal(racingGame);
    }
}
