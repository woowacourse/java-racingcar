package domain;

public record Attempts(int numberOfAttempts) {
    // 시도 횟수를 1~10으로 설정
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 10;

    public Attempts {
        if (isNumberOfAttemptsOutOfRange(numberOfAttempts)) {
            throw new IllegalArgumentException("1부터 10 이하의 숫자를 입력하세요.\n");
        }
    }

    private boolean isNumberOfAttemptsOutOfRange(int numberOfAttempts) {
        return numberOfAttempts < START_RANGE || numberOfAttempts > END_RANGE;
    }
}
