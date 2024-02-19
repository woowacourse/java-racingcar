package model;

import java.util.regex.Pattern;

public class Round {

    public static final Pattern NATURAL_NUMBER_FORMAT_REGEX = Pattern.compile("^[\\d]*$");
    private static final String NOT_EXISTS_ROUND = "0";

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(String round) {
        validateRound(round);
        return new Round(Integer.parseInt(round));
    }

    private static void validateRound(String round) {
        if (round == null || !NATURAL_NUMBER_FORMAT_REGEX.matcher(round).matches() || round.equals(NOT_EXISTS_ROUND)) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
