package controller;

import domain.RacingGame;
import domain.RandomNumberGenerator;
import view.input.InputView;
import view.output.ConsoleView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final ConsoleView consoleView;
    private RacingGame racingGame;

    public RacingController(InputView inputView, ConsoleView consoleView) {
        this.inputView = inputView;
        this.consoleView = consoleView;
    }

    public void start() {
        try {
            makeRacingGame(readCarNames(), readGameTry());
            startRacingGame();
            makeRacingGameResult();
        } catch (IllegalArgumentException e) {
            consoleView.printExceptionMessage(e.getMessage());
            start();
        }
    }

    private void makeRacingGame(List<String> carNames, int gameTry) {
        this.racingGame = new RacingGame(carNames, gameTry, new RandomNumberGenerator());
    }

    private List<String> readCarNames() {
        try {
            return inputView.readCarName();
        } catch (IllegalArgumentException e) {
            consoleView.printExceptionMessage(e.getMessage());
            return readCarNames();
        }
    }

    private void startRacingGame() {
        consoleView.printGameResultMessage();
        while (racingGame.isGameOnGoing()) {
            racingGame.start();
            consoleView.printRacingStatus(racingGame.getCars());
        }
    }

    private int readGameTry() {
        try {
            return inputView.readGameTry();
        } catch (IllegalArgumentException e) {
            consoleView.printExceptionMessage(e.getMessage());
            return readGameTry();
        }
    }

    private void makeRacingGameResult() {
        consoleView.printRacingStatus(racingGame.getCars());
        consoleView.printRacingWinners(racingGame.getWinners());
    }
}
