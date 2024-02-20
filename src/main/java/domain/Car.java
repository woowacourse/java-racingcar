package domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        validate(name);
        position = 0;
        this.name = name;
    }

    Car(final String name, final int position) {
        this(name);
        this.position = position;
    }

    public void move(final int number) {
        if (number >= 4) {
            position++;
        }
    }

    public boolean isPositionedAt(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validate(final String name) {
        if (isNameLengthOutOfRange(name)) {
            throw new IllegalArgumentException("1이상 5이하의 이름을 입력하세요.\n");
        }
    }

    private boolean isNameLengthOutOfRange(final String name) {
        return name.length() < 1 || name.length() > 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
