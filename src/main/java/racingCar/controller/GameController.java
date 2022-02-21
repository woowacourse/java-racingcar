package racingCar.controller;

import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class GameController {
    private final RacingGame racingGame;

    public GameController(InputView inputView) {
        racingGame = new RacingGame(inputView.getInitDto());
    }

    public void run(OutputView outputView) {
        playGame(outputView);
        endGame(outputView);
    }

    private void playGame(OutputView outputView) {
        OutputView.printStartMessage();
        playRounds(outputView);
    }

    private void endGame(OutputView outputView) {
        outputView.printWinner(racingGame.getWinnerCarsDto());
    }

    private void playRounds(OutputView outputView) {
        racingGame.go();
        outputView.printRoundResult(racingGame.getCarsDto());
        if (racingGame.getRoundCount().isFinish()) {
            return;
        }
        playRounds(outputView);
    }
}