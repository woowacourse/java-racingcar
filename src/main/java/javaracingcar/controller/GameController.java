package javaracingcar.controller;

import javaracingcar.domain.RacingGame;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;

import java.util.List;

public class GameController {
    public static void start() {
        try {
            run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            start();
        }
    }

    public static void run() {
        RacingGame racingGame = initGame();
        playRace(racingGame);
        printWinners(racingGame);
    }

    private static RacingGame initGame() {
        List<String> carNames = InputController.getCarNames(InputView.receiveCarNamesFromUser());
        int trial = InputController.getTrial(InputView.receiveTrialFromUser());

        return RacingGame.init(carNames, trial);
    }

    private static void playRace(RacingGame racingGame) {
        OutputView.printResultTitle();
        racingGame.playRace();
    }

    private static void printWinners(RacingGame racingGame) {
        OutputView.printWinners(racingGame.getWinners());
    }
}
