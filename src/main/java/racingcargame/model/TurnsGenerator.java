package racingcargame.model;

public class TurnsGenerator {
    public static int makeTurns(String input) {
        int totalTurns = Integer.parseInt(input);
        TurnsValidator.checkConditions(totalTurns);
        return totalTurns;
    }
}
