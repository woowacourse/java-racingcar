package racinggame.domain;

public class Round {

    private static final int MIN_ROUND_RANGE = 1;
    private static final int MAX_ROUND_RANGE = 10;
    private static final int DECREASE_AMOUNT = 1;
    private static final int PLAYABLE_STANDARD = 0;

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(int round) {
        checkRoundInRange(round);

        return new Round(round);
    }

    private static void checkRoundInRange(int round) {
        if (round < MIN_ROUND_RANGE || round > MAX_ROUND_RANGE) {
            throw new RuntimeException();
        }
    }

    public boolean isPlayable() {
        return round > PLAYABLE_STANDARD;
    }

    public Round decrease() {
        return new Round(round - DECREASE_AMOUNT);
    }
}
