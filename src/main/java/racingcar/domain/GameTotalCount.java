package racingcar.domain;

public class GameTotalCount {

    private static final int GAME_END_CONDITION = 0;

    private int totalAttemptCount;

    public GameTotalCount(String attempt) {
        this.totalAttemptCount = translatePositiveInteger(attempt);
    }

    public int getTotalAttemptCount() {
        return totalAttemptCount;
    }

    public boolean isContinue() {
        if (totalAttemptCount == GAME_END_CONDITION) {
            return false;
        }

        reduceAttemptCount();

        return true;
    }

    private void reduceAttemptCount() {
        totalAttemptCount = totalAttemptCount - 1;
    }

    private int translatePositiveInteger(String attempt) {
        int number;

        try {
            number = Integer.parseInt(attempt);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }

        validatePositiveNumber(number);

        return number;
    }

    private void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }
}
