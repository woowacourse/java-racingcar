package racingcar.domain;

public class Car {
    private static final String STRING_JOIN_DELIMITER = " : ";
    private static final String MOVE_EXPRESSION = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name + STRING_JOIN_DELIMITER + MOVE_EXPRESSION.repeat(Math.max(0, this.position));
    }
}
