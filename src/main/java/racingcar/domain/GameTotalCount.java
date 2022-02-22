package racingcar.domain;

public class GameTotalCount {

    private static final int GAME_END_CONDITION = 0;

    private int totalAttemptCount;

    private GameTotalCount(int totalAttemptCount) {
        validatePositiveNumber(totalAttemptCount);
        this.totalAttemptCount = totalAttemptCount;
    }

    public static GameTotalCount createGameTotalCount(String attempt) {
        int number = translateInteger(attempt);

        return new GameTotalCount(number);
    }

    public int getTotalAttemptCount() {
        return totalAttemptCount;
    }

    public boolean isContinue() {
        if (totalAttemptCount == GAME_END_CONDITION) {
            return false;
        }

        return true;
    }

    public void reduceAttemptCount() {
        totalAttemptCount = totalAttemptCount - 1;
    }

    private static int translateInteger(String attempt) {
        try {
            return Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }
}
