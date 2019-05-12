/*
 * @(#)RacingGameController.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */

package controller;

import model.*;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class RacingGameController {
    /*RacingCar 게임의 전체적인 로직(controller)를 담당하는 클래스*/
    private Cars cars;
    private LapCount lapCount;

    public RacingGameController(String inputCarNames, String lapCount) {
        this.cars = new Cars(inputCarNames);
        this.lapCount = new LapCount(lapCount);
    }

    public LapRecorder run() throws CloneNotSupportedException {
        Racing racing = new Racing(cars);
        LapRecorder lapRecorder = new LapRecorder();

        for (int lapNo = 1; lapNo <= lapCount.getLapCount(); lapNo++) {
            lapRecorder.record(new Cars(racing.run()));
        }

        return lapRecorder;
    }

    public Winners getWinners() {
        GameResult gameResult = new GameResult();
        return gameResult.findWinner(cars);
    }
}
