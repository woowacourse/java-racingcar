package racingcargame.model;

public class TurnsValidator {
    public static void checkConditions(int totalTurns) {
        checkMoreThanZero(totalTurns);
    }

    private static void checkMoreThanZero(int totalTurns) {
        if (totalTurns <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
