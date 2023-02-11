package service.wrapper;

public class Round {

    private static final int ROUND_MIN_VALUE = 1;

    private int round;

    public Round(int round) {
        this.round = round;
    }

    public boolean isRacing() {
        return round-- >= ROUND_MIN_VALUE;
    }
}
