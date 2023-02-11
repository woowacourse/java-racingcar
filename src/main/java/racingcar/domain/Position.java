package racingcar.domain;

public class Position {
    private static final int FORWARD_ONE_BLOCK = 1;
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position += FORWARD_ONE_BLOCK;
    }

    public int getPosition() {
        return this.position;
    }

}
