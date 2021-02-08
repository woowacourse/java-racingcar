package racingcar.domain.car;

public class Position {

    private static final String UNIT_OF_POSITION = "-";

    private final StringBuilder position;

    public Position() {
        this.position = new StringBuilder();
    }

    public void forward() {
        position.append(UNIT_OF_POSITION);
    }

    public String toString() {
        return position.toString();
    }

    public boolean isWinner(int maxPosition) {
        return position.length() == maxPosition;
    }
}
