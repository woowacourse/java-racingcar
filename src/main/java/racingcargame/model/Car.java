package racingcargame.model;

import racingcargame.model.validation.CarValidation;

import java.util.Objects;

public class Car {
    private static final int POSITION_DEFAULT = 0;
    private static final int MOVE_POINT = 4;
    private static final String POSITION_MESSAGE = "-";

    private final String name;
    private int position;

    public Car(String name) {
        this(name, POSITION_DEFAULT);
    }

    public Car(String name, int position) {
        CarValidation.checkBlank(name);
        CarValidation.checkLength(name);

        this.name = name;
        this.position = position;
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

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        StringBuilder position = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            position.append(POSITION_MESSAGE);
        }

        return name + " : " + position.toString();
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
