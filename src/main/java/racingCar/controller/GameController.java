package racingCar.controller;

import racingCar.domain.RacingGame;
import racingCar.domain.dto.InitDto;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class GameController {
    private final RacingGame racingGame;

    public GameController() {
        InitDto initDto = InputView.get();
        racingGame = new RacingGame(initDto);
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
        OutputView.printWinner(racingGame.getWinnerCarsDto());
    }

    private void playRounds(RacingGame racingGame) {
        racingGame.go();
        OutputView.printRoundResult(racingGame.getCarsDto());
        if (racingGame.getRoundCount().isFinish()) {
            return;
        }
        playRounds(racingGame);
    }
}