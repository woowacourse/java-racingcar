package racingcar;

import racingcar.model.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = getRacingCarGame();
        OutputView.printResultSentence();
        while (racingCarGame.canRace()) {
            racingCarGame.race();
            OutputView.printResult(racingCarGame.getCarsPosition());
        }
        OutputView.printWinners(racingCarGame.getWinners());
    }

    private static RacingCarGame getRacingCarGame() {
        try {
            String carNames = InputView.getCarNames();
            int gameTurn = InputView.getGameTurn();
            return new RacingCarGame(carNames, gameTurn);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getRacingCarGame();
        }
    }
}
