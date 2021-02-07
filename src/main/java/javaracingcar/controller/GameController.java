package javaracingcar.controller;

import javaracingcar.domain.Game;
import javaracingcar.view.OutputView;

import java.util.List;

public class GameController {
    public static void run(List<String> carNames, int trial) throws IllegalArgumentException {
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
