package racing.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int GO_FORWRARD_CRITERIA_NUM = 4;
    private static final int GO_STEP = 1;
    private static final int START_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    static final int RANDOM_NUM_UPPER_BOUND = 10;

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, START_POSITION);
    }

    public Car(final String name, final int position) {
        validateNameLength(name);
        this.name = name.trim();
        this.position = position;
    }

    private static void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH)
            throw new IllegalArgumentException("차 이름은 빈 문자열을 허용하지 않고 5글자 이내여야 합니다.");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryGoForward(final int randomNum) {
        if (isGo(randomNum)) position += GO_STEP;
    }

    private static boolean isGo(final int number) {
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