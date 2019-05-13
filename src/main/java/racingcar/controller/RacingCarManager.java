package racingcar.controller;

import racingcar.model.GameResult;
import racingcar.model.RacingCars;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarManager {
    private static final int MIN_GAME_COUNT = 0;

    private final GameResult gameResult;
    private int gameCount = 0;
    private RacingCars racingCars;

    public RacingCarManager() {
        this.gameResult = new GameResult();
    }

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
        printStartRacingMent();
        moveRaceCars();
    }

    private void printStartRacingMent() {
        OutputView.printResultMent();
    }

    private void moveRaceCars() {
        for (int i = 0; i < gameCount; i++) {
            moveRacingCarsOneCount();
        }
    }

    private void moveRacingCarsOneCount() {
        racingCars.moveRacingCars();
        gameResult.addResult(racingCars);
    }

    private void endRacing() {
        printResults();
        Winner winner = getWinner(racingCars);
        printWinners(winner);
    }

    private void printResults() {
        OutputView.printResults(gameResult);
    }

    private Winner getWinner(RacingCars racingCars) {
        return new Winner(racingCars).getWinners();
    }

    private void printWinners(Winner winner) {
        OutputView.printCarWinners(winner);
    }
}
