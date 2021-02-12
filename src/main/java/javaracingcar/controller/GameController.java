package javaracingcar.controller;

import javaracingcar.domain.Game;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;

public class GameController {

    public static void startGame() {
        String carNames = InputView.receiveCarNamesFromUser();
        String trial = InputView.receiveTrialFromUser();
        validateNotNull(carNames);
        validateNotNull(trial);
        GameController.run(carNames, trial.replaceAll(" ", ""));
    }

    private static void validateNotNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("null 이 입력되었습니다.");
        }
    }

    private static void run(String carNames, String trial) {
        Game game = Game.init(carNames, trial);
        race(game);
        OutputView.printWinners(game.getCars().getWinners());
    }

    private static void race(Game game) {
        OutputView.printResultTitle();
        while (!game.isEnd()) {
            playOneRound(game);
            game.reduceOneTrial();
        }
    }

    private static void playOneRound(Game game) {
        game.moveCars();
        OutputView.printRoundResult(game.getCars());
    }
}
