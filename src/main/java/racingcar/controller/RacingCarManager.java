package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarManager {
    private int gameCount = 0;
    private RacingCars racingCars;

    public void playRacingGame() {
        getGameInformation();
        startRacing();
        endRacing();
    }

    private void getGameInformation() {
        racingCars = new RacingCars(InputView.getRacingCarInput());
        gameCount = InputView.getRacingCount();
        if (gameCount < 0) {
            throw new IllegalArgumentException("0이상의 숫자를 입력하세요");
        }
    }

    private void startRacing() {
        OutputView.printResultMent();
        for (int i = 0; i < gameCount; i++) {
            racingCars.moveRacingCars();
            OutputView.printCarPositions(racingCars);
            OutputView.printEmptyLine();
        }
    }

    private void endRacing() {
        Winner winner = new Winner(racingCars);
        printWinners(winner);
    }

    private void printWinners(Winner winner) {
        OutputView.printCarWinners(winner);
    }
}
