package racingcar;

import java.util.*;
import racingcar.view.InputView;

public class RacingGame {
    private static final int TOTAL_TURNS_LIMIT = 0;

    private final int totalTurns;


    RacingGame(int totalTurns) {
        checkConditionsForTotalTurns(totalTurns);
        this.totalTurns = totalTurns;
    }

    public static void checkConditionsForTotalTurns(int userInput) {
        if (userInput <= TOTAL_TURNS_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public static RacingGame openNewGame() {
        try{
            int totalTurns = InputView.askAndReceiveTotalTurns();
            RacingGame racingGame = new RacingGame(totalTurns);
            return racingGame;
        } catch (Exception e) {
            return openNewGame();
        }
    }

    public int getTotalTurns() {
        return totalTurns;
    }
}
