package racingcar.domain.car;

public class Position {
    public static final String UNIT_OF_POSITION = "-";

    private final StringBuilder position;

    Position() {
        this.position = new StringBuilder();
    }

    void forward() {
        position.append(UNIT_OF_POSITION);
    }

    public String toString() {
        return position.toString();
    }
}
