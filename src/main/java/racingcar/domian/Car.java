package racingcar.domian;

import java.util.Objects;

public class Car {
    private static final String EMPTY_STRING = "";
    private static final int INIT_POSITION = 0;
    private static final int LIMIT_FOR_MOVE = 4;
    private int position;
    private String name;

    public Car(String name) {
        this(INIT_POSITION, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void move(int inputValue) {
        if (inputValue >= LIMIT_FOR_MOVE) {
            this.position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    public int getPosition() {
        return this.position;
    }

    public String isWinner(int max) {
        if (isMaxPosition(max)) {
            return name;
        }
        return EMPTY_STRING;
    }

    public boolean isMaxPosition(int max) {
        return this.position == max;
    }

    public String getName() {
        return name;
    }
}
