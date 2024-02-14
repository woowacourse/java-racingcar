package racinggame;

public class Round {

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    // TODO : getter vs message
    public static Round from(int round) {
        if (round < 1 || round > 10) {
            throw new RuntimeException();
        }

        return new Round(round);
    }
}
