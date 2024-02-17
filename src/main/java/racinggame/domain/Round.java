package racinggame.domain;

public class Round {

    private static final int MIN_ROUND = 1;
    private static final int MAX_ROUND = 10;
    private static final int ZERO = 0;
    private static final int DECREASE_AMOUNT = 1;

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(int round) {
        checkRoundInRange(round);

        return new Round(round);
    }

    private static void checkRoundInRange(int round) {
        if (round < MIN_ROUND || round > MAX_ROUND) {
            throw new IllegalArgumentException(String.format("라운드는 1회 이상 10회 이하만 가능합니다. 입력한 라운드 수: %d", round));
        }
    }

    public boolean isPlayable() {
        return round > ZERO;
    }

    public Round decrease() {
        return new Round(round - DECREASE_AMOUNT);
    }
}
