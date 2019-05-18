package racingcargame.model;

public class TurnsValidator {
    private static final int TURNS_LIMIT = 0;
    public static void checkConditions(int totalTurns) {
        checkMoreThanZero(totalTurns);
    }

    private static void checkMoreThanZero(int totalTurns) {
        if (totalTurns <= TURNS_LIMIT) {
            throw new IllegalArgumentException();
        }
    }
}
