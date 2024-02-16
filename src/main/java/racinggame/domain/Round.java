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
            throw new IllegalArgumentException(String.format("라운드는 1회 이상 10회 이하만 가능합니다. 입력한 라운드 수: %d", round));
        }
    }

    public boolean isPlayable() {
        return round > 0;
    }

    public Round decrease() {
        return new Round(round - 1);
    }
}
