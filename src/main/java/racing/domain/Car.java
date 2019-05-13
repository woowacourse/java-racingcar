package racing.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int GO_FORWRARD_CRITERIA_NUM = 4;
    private static final int GO_STEP = 1;
    private static final int START_POSITION = 0;
    public static final int NAME_MAX_LENGTH = 5;
    static final int MAX_RANDOM_NUM_UPPER_BOUND = 10;

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, START_POSITION);
    }

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition(){
        return position;
    }
    public void tryGoForward(final int randomNum) {
        if (isGo(randomNum)) position += GO_STEP;
    }

    private boolean isGo(final int number) {
        return number >= GO_FORWRARD_CRITERIA_NUM;
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
        return Objects.hash(name, position);
    }

    @Override
    public int compareTo(Car another) {
        if (position < another.position) {
            return -1;
        }
        if (position > another.position) {
            return 1;
        }
        return 0;
    }
}