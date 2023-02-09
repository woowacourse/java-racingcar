package controller;

import domain.RacingGame;
import view.input.InputView;
import view.output.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private RacingGame racingGame;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        makeRacingGame();
        startRacingGame();
        makeRacingGameResult();
    }

    private void makeRacingGame() {
        try {
            this.racingGame = new RacingGame(inputView.readCarName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeRacingGame();
        }
    }

    private void startRacingGame() {
        try {
            int gameTry = inputView.readGameTry();
            outputView.printGameResultMessage();
            for (int i = 0; i < gameTry; i++) {
                racingGame.start();
                outputView.printRacingStatus(racingGame.getCars());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startRacingGame();
        }
    }

    private void makeRacingGameResult() {
        outputView.printRacingStatus(racingGame.getCars());
        outputView.printRacingWinners(racingGame.getWinners());
    }
}
