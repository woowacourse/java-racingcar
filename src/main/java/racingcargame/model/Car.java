package racingcargame.model;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkLength(name);
        checkBlank(name);
        this.name = name;
        this.position = position;
    }

    private void checkLength(String name){
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBlank(String name){
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
        if (randomNum >= 4) {
            position++;
        }
    }

    public boolean matchPosition(int position){
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
