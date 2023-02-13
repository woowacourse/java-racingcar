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
        RacingGame racingGame = setRacingGame();
        int movingTrial = inputView.readMovingTrial();
        outputView.printNotice();
        raceWithHistory(movingTrial, racingGame);
        outputView.printWinner(racingGame.getRacingResult().getWinner());
    }

    private RacingGame setRacingGame() throws IOException {
        try {
            List<String> carNames = inputView.readCarNames();
            return new RacingGame(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRacingGame();
        }
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
