package racingcar.model;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Car {
    private final int FOWARD_NUM = 4;

    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validName(name);

        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void makeNewCar(int randomNumber) {
        move(randomNumber);
        new Car(this.name, this.position);
    }

    public int comparePosition(int position) {
        if (this.position > position) {
            return this.position;
        }

        return position;
    }

    public String matchPosition(int position) {
        if (this.position == position) {
            return this.name;
        }

        return "";
    }

    private void move(int randomNumber) {
        if (randomNumber >= FOWARD_NUM) {
            this.position++;
        }
    }

    private void validName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException();
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
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
