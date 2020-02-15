package racingcar.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }

    @Override
    public boolean equals(Object obj) {
        Position target = (Position)obj;
        return this.position == target.position;

    }
}
