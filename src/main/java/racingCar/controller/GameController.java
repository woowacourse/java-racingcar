package racingCar.controller;

import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class GameController {
    private final RacingGame racingGame;

    public GameController() {
        String names = InputView.getNames();
        String count = InputView.getCount();
        racingGame = new RacingGame(names, count);
    }

    public void run() {
        playGame(racingGame);
        endGame(racingGame);
    }

    private void playGame(RacingGame racingGame) {
        OutputView.printStartMessage();
        playRounds(racingGame);
    }

    private void endGame(RacingGame racingGame) {
        OutputView.printWinner(racingGame.getWinnerCars());
    }

    private void playRounds(RacingGame racingGame) {
        racingGame.go();
        OutputView.printRoundResult(racingGame.getResult());
        if (racingGame.getRoundCount().isFinish()) {
            return;
        }
        playRounds(racingGame);
    }
}