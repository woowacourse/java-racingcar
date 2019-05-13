package racingcar;

import racingcar.view.InputView;

public class RacingGame {
    private final int totalTurns;

    RacingGame(int totalTurns) {
        checkConditionsForTotalTurns(totalTurns);
        this.totalTurns = totalTurns;
    }

    public static void checkConditionsForTotalTurns(int userInput) {
        if (userInput <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static RacingGame instantiateRacingGame() {
        try{
            int totalTurns = InputView.askAndReceiveTotalTurns();
            RacingGame racingGame = new RacingGame(totalTurns);
            return racingGame;
        } catch (Exception e) {
            return instantiateRacingGame();
    }

    }
}
