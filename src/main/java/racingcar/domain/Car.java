package racingcar.domain;

public class Car {
    private static final String MARKER_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MARKER_OF_POSITION = "-";
    private static final int MOVING_BASELINE = 4;
    private static final int INITIAL_POSITION = 0;

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public String getName() {
        return this.name.getName();
    }

    public int movePosition(int value) {
        if (value >= MOVING_BASELINE) {
            position++;
        }
        return position;
    }

    public String getCurrentPosition() {
        StringBuilder current = new StringBuilder(name.getName());
        current.append(MARKER_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < position; i++) {
            current.append(MARKER_OF_POSITION);
        }
        return current.toString();
    }

    public boolean hasSamePositionWith(Car positionCar) {
        return this.position == positionCar.position;
    }

    public int compareTo(Car car) {
        return this.position - car.position;
    }
}