package racingCar.controller;

import racingCar.domain.RacingGame;
import racingCar.domain.dto.InitDto;
import racingCar.view.OutputView;

public class GameController {
    private final RacingGame racingGame;

    public GameController(InitDto initDto) {
        racingGame = new RacingGame(initDto);
    }

    public void run() {
        playGame();
        endGame();
    }

    private void playGame() {
        OutputView.printStartMessage();
        playRounds();
    }

    private void endGame() {
        OutputView.printWinner(racingGame.getWinnerCarsDto());
    }

    private void playRounds() {
        racingGame.go();
        OutputView.printRoundResult(racingGame.getCarsDto());
        if (racingGame.getRoundCount().isFinish()) {
            return;
        }
        playRounds();
    }
}