package racingcar.domain;

import racingcar.constant.ErrorLog;

public class GameStatusChecker {
    private final int NumberOfRounds;

    public GameStatusChecker(int NumberOfRounds) {
        this.NumberOfRounds = NumberOfRounds;
    }

    public boolean isOngoing(int currentRound) {
        if (currentRound > NumberOfRounds) {
            throw new IllegalArgumentException(ErrorLog.OVER_FINAL_ROUND_NUMBER.getMessage());
        }
        return NumberOfRounds != currentRound;
    }
}
