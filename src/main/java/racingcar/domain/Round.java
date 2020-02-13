package racingcar.domain;

public class Round {
    public static final int MAX_TOTAL_ROUND = 100;
    public static final int START_ROUND = 1;
    public static final String TOTAL_ROUND_OUT_OF_RANGE_MESSAGE = "총 라운드 수가 범위를 벗어났습니다.";

    private final int totalRound;
    private int currentRound;

    public Round(final int totalRound) {
        validateTotalRound(totalRound);
        this.totalRound = totalRound;
        currentRound = START_ROUND;
    }

    private void validateTotalRound(final int totalRound) {
        if (totalRound < START_ROUND || totalRound > MAX_TOTAL_ROUND) {
            throw new IllegalArgumentException(TOTAL_ROUND_OUT_OF_RANGE_MESSAGE);
        }
    }

    public void next() {
        if (currentRound>=totalRound) {
            throw new IllegalArgumentException("최종 라운드입니다.");
        }
        currentRound++;
    }

    public boolean isRoundOf(int round) {
        return currentRound == round;
    }

    public boolean isFinal() {
        return currentRound == totalRound;
    }
}
