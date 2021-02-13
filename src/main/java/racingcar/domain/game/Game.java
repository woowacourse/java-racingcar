package racingcar.domain.game;

public class Game {

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
