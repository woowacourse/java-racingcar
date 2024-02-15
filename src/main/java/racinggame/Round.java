package racinggame;

public class Round {

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(int round) {
        if (round < 1 || round > 10) {
            throw new RuntimeException();
        }

        return new Round(round);
    }

    public boolean isEnd() {
        return round == 0;
    }

    public Round decrease() {
        return new Round(round - 1);
    }
}
