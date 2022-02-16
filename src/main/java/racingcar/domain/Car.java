package racingcar.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final String STRING_JOIN_DELIMITER = " : ";
    private static final String MOVE_EXPRESSION = "-";

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION) {
            position++;
        }
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
