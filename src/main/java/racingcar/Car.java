package racingcar;

public class Car {
    private static final String STRING_JOIN_DELIMITER = " : ";
    private static final String MOVE_EXPRESSION = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.name + STRING_JOIN_DELIMITER);
        for (int i = 0; i < this.position; i++) {
            result.append(MOVE_EXPRESSION);
        }
        return result.toString();
    }
}
