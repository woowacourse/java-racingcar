package racingcargame.model;

public class Turns {
    private int turns;

    public Turns(String turns) {
        int totalTurns = Integer.parseInt(turns);
        checkTotalTurns(totalTurns);
        this.turns = totalTurns;
    }

    private void checkTotalTurns(int totalTurns) {
        if (totalTurns < 1 || totalTurns > 5) {
            throw new IllegalArgumentException();
        }
    }

    public int getTurns() {
        return turns;
    }
}
