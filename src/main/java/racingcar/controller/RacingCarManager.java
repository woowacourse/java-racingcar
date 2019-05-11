package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarManager {
    private static final int MIN_GAME_COUNT = 0;
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
        if (gameCount < MIN_GAME_COUNT) {
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
        Winner winner = getWinner(racingCars);
        printWinners(winner);
    }

    private Winner getWinner(RacingCars racingCars) {
        return new Winner(racingCars).getWinners();
    }

    private void printWinners(Winner winner) {
        OutputView.printCarWinners(winner);
    }
}
