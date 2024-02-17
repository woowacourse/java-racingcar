package racinggame.domain;

public class Round {

    private static final int MIN_ROUND_RANGE = 1;
    private static final int MAX_ROUND_RANGE = 10;
    private static final int DECREASE_AMOUNT = 1;
    private static final int PLAYABLE_STANDARD = 0;

    private int round;

    public Round(int round) {
        checkRoundInRange(round);

        this.round = round;
    }

    private void checkRoundInRange(int round) {
        if (round < MIN_ROUND_RANGE || round > MAX_ROUND_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isPlayable() {
        return round > PLAYABLE_STANDARD;
    }

    public void decrease() {
        round -= DECREASE_AMOUNT;
    }
}
