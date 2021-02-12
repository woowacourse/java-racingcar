package javaracingcar.controller;

import javaracingcar.domain.Game;
import javaracingcar.view.InputView;
import javaracingcar.view.OutputView;

public class GameController {

    public static void startGame() {
        String carNames = InputView.receiveCarNamesFromUser();
        String trial = InputView.receiveTrialFromUser();
        run(carNames, trial.replaceAll(" ", ""));
    }

    private static void run(String carNames, String trial) {
        Game game = initializeGame(carNames, trial);
        race(game);
        printWinner(game);
    }

    private static Game initializeGame(String carNames, String trial) {
        return Game.init(carNames, trial);
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

    private static void printWinner(Game game) {
        OutputView.printWinners(game.getCars().getWinners());
    }
}
