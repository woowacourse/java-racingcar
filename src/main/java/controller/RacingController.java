package controller;

import domain.RacingGame;
import domain.RandomNumberGenerator;
import view.input.InputView;
import view.output.OutputView;

import java.util.List;

public class RacingController {

    private RacingGame racingGame;

    public void start() {
        makeRacingGame(readCarNames());
        startRacingGame(readGameTry());
        makeRacingGameResult();
    }

    private void makeRacingGame(final List<String> carNames) {
        try {
            this.racingGame = new RacingGame(carNames, new RandomNumberGenerator());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            makeRacingGame(readCarNames());
        }
    }

    private List<String> readCarNames() {
        try {
            return InputView.readCarName();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return readCarNames();
        }
    }

    private void startRacingGame(final int gameTry) {
        OutputView.printGameResultMessage();
        for (int i = 0; i < gameTry; i++) {
            racingGame.start();
            OutputView.printRacingStatus(racingGame.getCars());
        }
    }

    private int readGameTry() {
        try {
            return InputView.readGameTry();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return readGameTry();
        }
    }

    private void makeRacingGameResult() {
        OutputView.printRacingStatus(racingGame.getCars());
        OutputView.printRacingWinners(racingGame.getWinners());
    }
}
