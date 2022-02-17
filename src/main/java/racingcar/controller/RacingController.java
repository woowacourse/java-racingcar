package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.utils.NumberGenerator;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingController {

    public void play(NumberGenerator numberGenerator) {
        RacingGame racingGame = startRacingGame(numberGenerator);
        printResultMessage();

        while (!racingGame.isFinished()) {
            racingGame.playTurn();
            printCars(racingGame.getCars());
        }
        printWinners(racingGame.getCars());
    }

    private RacingGame startRacingGame(NumberGenerator numberGenerator) {
        Cars cars = new Cars(getRightName());
        int trialCount = getRightNumber();
        return new RacingGame(cars, trialCount, numberGenerator);
    }

    private String[] getRightName() {
        try {
            return insertRightName();
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            return getRightName();
        }
    }

    private int getRightNumber() {
        try {
            return insertRightNumber();
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            return getRightNumber();
        }
    }

}
