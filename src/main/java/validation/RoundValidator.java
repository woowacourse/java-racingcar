package validation;

public class RoundValidator {
    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 100;

    public static void validateRound(int round) {
        if (round < MIN_ROUND || round > MAX_ROUND) {
            throw new IllegalArgumentException("1-100로 시도 횟수를 적어주세요.");
        }
    }
}
