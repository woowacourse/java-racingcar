package racing.controller;

import java.io.IOException;

import racing.domain.RacingGame;
import racing.handler.InputHandler;
import racing.view.OutputView;

public class RacingGameController {

    private final InputHandler inputHandler;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputHandler = new InputHandler();
        this.outputView = new OutputView();
    }

    public void run() throws IOException {
        String[] carNames = inputHandler.readCars();
        int movingTrial = inputHandler.readMovingTrial();

        RacingGame racingGame = new RacingGame(carNames);

        outputView.printNotice();
        raceWithHistory(movingTrial, racingGame);
        outputView.printWinner(racingGame.getRacingResult().getWinner());
    }

    private void raceWithHistory(int movingTrial, RacingGame racingGame) {
        //TODO: 인덱스를 쓰지 않는데 개선할 방법
        for (int i = 0; i < movingTrial; i++) {
            racingGame.race();

            outputView.printRacingResult(racingGame.getRacingResult().getHistory());
        }
    }
}
