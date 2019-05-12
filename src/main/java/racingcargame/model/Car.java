package racingcargame.model;

import java.util.Objects;

public class Car {
    private static final int POSITION_DEFAULT = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_POINT = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, POSITION_DEFAULT);
    }

    public Car(String name, int position) {
        checkLength(name);
        checkBlank(name);
        this.name = name;
        this.position = position;
    }

    private void checkLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBlank(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNum) {
        if (randomNum >= MOVE_POINT) {
            position++;
        }
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
