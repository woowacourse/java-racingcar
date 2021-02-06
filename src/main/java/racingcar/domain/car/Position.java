package racingcar.domain.car;

public class Position {
    public static final String UNIT_OF_POSITION = "-";

    private final StringBuilder position;

    public Position() {
        this.position = new StringBuilder();
    }

    public void moveForward() {
        position.append(UNIT_OF_POSITION);
    }

    public String getPosition() {
        return position.toString();
    }
}
