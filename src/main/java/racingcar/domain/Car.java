package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkName(name);
        this.name = name.trim();
        this.position = position;
    }

    private void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름이 정상적으로 입력되지 않았습니다. (null)");
        }
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 정상적으로 입력되지 않았습니다. (1~5글자만 가능합니다.)");
        }
    }

    protected void move(int number) {
        position += (number >= FORWARD_NUM) ? 1 : 0;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    public int findPositionBiggerThan(int position) {
        return (this.position > position) ? this.position : position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
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
}
