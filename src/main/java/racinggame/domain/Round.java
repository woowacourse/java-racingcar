package racinggame.domain;

public class Round {

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(int round) {
        checkRoundInRange(round);

        return new Round(round);
    }

    private static void checkRoundInRange(int round) {
        if (round < 1 || round > 10) {
            throw new RuntimeException();
        }
    }

    public boolean isPlayable() {
        return round > 0;
    }

    public Round decrease() {
        return new Round(round - 1);
    }
}
