package racingcar.domain.game;

public class Game {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;

    private final int round;
    private int count = 0;

    public Game(int round) {
        this.round = round;
    }

    public boolean notFinished() {
        return round != count;
    }

    public void incrementCount() {
        ++count;
    }
}
