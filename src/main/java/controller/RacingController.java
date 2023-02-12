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
            makeRacingGame(readCarNames());
            startRacingGame(readGameTry());
            makeRacingGameResult();
        } catch (IllegalArgumentException e) {
            consoleView.printExceptionMessage(e.getMessage());
            start();
        }
    }

    private void makeRacingGame(List<String> carNames) {
        this.racingGame = new RacingGame(carNames, new RandomNumberGenerator());
    }

    private List<String> readCarNames() {
        try {
            return inputView.readCarName();
        } catch (IllegalArgumentException e) {
            consoleView.printExceptionMessage(e.getMessage());
            return readCarNames();
        }
    }

    private void startRacingGame(int gameTry) {
        consoleView.printGameResultMessage();
        for (int i = 0; i < gameTry; i++) {
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
