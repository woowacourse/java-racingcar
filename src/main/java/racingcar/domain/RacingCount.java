package racingcar.domain;

public record RacingCount(int count) {

    private static final int MIN_ROUND_COUNT = 1;

    public RacingCount {
        validateCount(count);
    }

    private void validateCount(final int count) {
        if (count < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("1이상의 숫자가 입력되어야 합니다.");
        }
    }

    public boolean isFinish(int playedCount) {
        return playedCount >= count;
    }
}
