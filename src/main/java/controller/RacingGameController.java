package controller;

import java.io.IOException;

import domain.RacingGame;
import handler.InputHandler;
import view.OutputView;

public class RacingGameController {

    private final InputHandler inputHandler;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputHandler = new InputHandler();
        this.outputView = new OutputView();
    }

    public void run() throws IOException {
        RacingGame racingGame = inputHandler.readCars();
        int movingTrial = inputHandler.readMovingTrial();

        outputView.printNotice();
        raceWithHistory(movingTrial, racingGame);
        outputView.printWinner(racingGame.getRacingResult().getWinner());
    }

    private void raceWithHistory(int movingTrial, RacingGame racingGame) {
        for (int i = 0; i < movingTrial; i++) {
            racingGame.race();

            outputView.printRacingResult(racingGame
                    .getRacingResult()
                    .getHistory());
        }
    }
}
