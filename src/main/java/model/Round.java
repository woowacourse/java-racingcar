package model;

import java.util.regex.Pattern;

public class Round {

    private static final String NATURAL_FORMAT_REGEX = "^[\\d]*$";
    private static final String ZERO = "0";

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(String round) {
        validateRound(round);
        return new Round(Integer.parseInt(round));
    }

    private static void validateRound(String round) {
        if (round == null || !Pattern.matches(NATURAL_FORMAT_REGEX, round) || round.equals(ZERO)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 자연수여야 합니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
