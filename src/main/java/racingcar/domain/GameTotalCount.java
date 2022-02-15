package racingcar.domain;

public class GameTotalCount {

    private int totalAttemptCount;

    public GameTotalCount(String attempt) {
        initTotalAttempt(attempt);
    }

    public int getTotalAttemptCount() {
        return totalAttemptCount;
    }

    private int initTotalAttempt(String attempt) throws IllegalArgumentException {
        int validateAttempt = validateAttempt(attempt);
        this.totalAttemptCount = validateAttempt;
    }


    private int validateAttempt(String attempt) {
        int number = translateVerifiedInteger(attempt);
        validatePositiveNumber(number);

        return number;
    }

    private int translateVerifiedInteger(String attempt) {
        try {
            return Integer.parseInt(attempt);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }
}
