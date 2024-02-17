package domain;

public class Position {
    private static final Integer INITIAL_POSITION = 0;

    private Integer position;

    Position(Integer position) {
        this.position = position;
    }

    public Position() {
        this(INITIAL_POSITION);
    }

    public void move() {
        position++;
    }

    public Integer getPosition() {
        return position;
    }
}
