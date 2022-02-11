package racingcar.domain;

public class Round {
    private static final int ZERO = 0;

    private int roundNum;

    public Round(int roundNum) {
        this.roundNum = roundNum;
    }

    public static Round from(int round) {
        return new Round(round);
    }

    public boolean hasNext() {
        return roundNum-- > ZERO;
    }
}
