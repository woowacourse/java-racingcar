package domain;

public class Round {

    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 100;

    private final int round;

    public Round(String rawRound) {
        this.round = validate(rawRound);
    }

    private int validate(String rawRound) {
        int number = validateNonNumber(rawRound);
        validateRange(number);
        return number;
    }

    private int validateNonNumber(String rawRound) {
        try {
            return Integer.parseInt(rawRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validateRange(int round) {
        if (round < MIN_ROUND || round > MAX_ROUND) {
            throw new IllegalArgumentException(
                "시도 횟수는 " + MIN_ROUND + " ~ " + MAX_ROUND + "만 입력 가능합니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
