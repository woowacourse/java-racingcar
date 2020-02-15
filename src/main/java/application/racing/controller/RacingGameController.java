package application.racing.controller;

import application.racing.domain.Cars;
import application.racing.domain.RacingGame;
import application.racing.domain.RacingLab;
import application.racing.view.InputViewer;
import application.racing.view.OutputViewer;

public class RacingGameController {
    private static Cars cars;
    private static RacingLab racingLab;
    private static RacingGame racingGame;

    public static void run() {
        initializeCars();
        initializeRacingLab();
        race();
        OutputViewer.printWinner(cars.findWinner());
    }

    private static void initializeCars() {
        boolean flag = false;
        while (!flag) {
            try {
                cars = new Cars(InputViewer.getCarsName());
                flag = true;
            } catch (IllegalArgumentException e) {
                OutputViewer.printErrorMessage(e.getMessage());
            }
        }
    }

    private static void initializeRacingLab() {
        boolean flag = false;
        while (!flag) {
            try {
                racingLab = new RacingLab(InputViewer.getRacingLab());
                flag = true;
            } catch (IllegalArgumentException e) {
                OutputViewer.printErrorMessage(e.getMessage());
            }
        }
    }

    private static void race() {
        racingGame = new RacingGame();
        OutputViewer.printRacingResultMessage();
        while (!racingGame.isEnd(racingLab)) {
            racingGame.raceOneLab(cars);
            OutputViewer.printPositionDuringRace(cars);
        }
    }
}
