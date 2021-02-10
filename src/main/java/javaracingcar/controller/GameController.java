package javaracingcar.controller;

import javaracingcar.domain.Game;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;

import java.util.List;

public class GameController {

    public static void startGame() {
        String carNames = InputView.receiveCarNamesFromUser();
        String trial = InputView.receiveTrialFromUser();
        GameController.run(carNames, trial);
    }

    private static void run(String carNames, String trial) throws IllegalArgumentException {
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
