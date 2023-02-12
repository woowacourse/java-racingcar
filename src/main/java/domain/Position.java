package domain;

public class Position {

    private int position;

    public Position(final int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
