package model;

public class Round {
    private final int round;
    private static final String format = "[1-9]\\d*";
    private static final String INVALID_FORMAT_ERROR_MESSAGE = "시도 횟수는 양의 정수여야만 합니다.";

    public Round(String round) {
        validateRound(round);

        this.round = Integer.parseInt(round);
    }

    public static void validateRound(String invalidRound) {
        if (!invalidRound.matches(format)) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
        }
    }

    public int getRound() {
        return round;
    }
}
