package javaracingcar.controller;

import javaracingcar.domain.Game;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;

import java.util.List;

public class GameController {

    public static void startGame() {
        List<String> carNames = InputController.getCarNames(InputView.receiveCarNamesFromUser());
        int trial = InputController.getTrial(InputView.receiveTrialFromUser());
        GameController.run(carNames,trial);
    }

    private static void run(List<String> carNames, int trial) throws IllegalArgumentException {
        Game game = Game.init(carNames, trial);
        race(game);
        OutputView.printWinners(game.getWinners());
    }

    private static void race(Game game) {
        OutputView.printResultTitle();
        while (!game.isEnd()) {
            playOneRound(game);
            game.reduceOneTrial();
        }
    }

    private static void playOneRound(Game game) {
        game.playMoveOrStop();
        OutputView.printRoundResult(game);
    }
}
