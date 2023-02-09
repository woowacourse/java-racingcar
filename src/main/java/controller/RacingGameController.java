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

        //TODO: 인덱스를 쓰지 않는데 개선할 방법
        for (int i = 0; i < movingTrial; i++) {
            racingGame.racing();

            outputView.printRacingResult(racingGame
                    .getRacingResult()
                    .getHistory());
        }
        outputView.printWinner(racingGame.getRacingResult().getWinner());
    }
}
