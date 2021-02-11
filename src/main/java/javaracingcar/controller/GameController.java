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

        return new RacingGame(carNames, trial);
    }

    private static void playRace(RacingGame racingGame) {
        OutputView.printResultTitle();
        while (!racingGame.isEnd()) {
            racingGame.playOneRound();
            OutputView.printRoundResult(racingGame);
        }
    }

    private static void printWinners(RacingGame racingGame) {
        OutputView.printWinners(racingGame);
    }
    // TODO: 고민: racingGame 객체 vs List<String> winners 객체를 넘기기 (view 는 도메인 객체의 구성을 몰라야?)
}
