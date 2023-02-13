package controller;

import java.io.IOException;
import java.util.List;

import domain.RacingGame;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() throws IOException {
        List<String> carNames = inputView.readCarNames();
        RacingGame racingGame = new RacingGame(carNames);
        int movingTrial = inputView.readMovingTrial();

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
