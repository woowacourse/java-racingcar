package racingcargame.model;

public class Turns {
    private static final int MINIMUM_TURN = 1;
    private int turns;

    public Turns(String turns) {
        int totalTurns = Integer.parseInt(turns);
        checkTotalTurns(totalTurns);
        this.turns = totalTurns;
    }

    private void checkTotalTurns(int totalTurns) {
        if (totalTurns < MINIMUM_TURN) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isTurnsNotFinished(int currentTurn) {
        return turns != currentTurn;
    }
}
