package racingcar.model.vo;

import java.util.Objects;

public class Car {
    private static final int MAXIMUM_LENGTH = 5;
    private static final int MINIMUM_LENGTH = 1;
    private static final String ERROR_MESSAGE_FOR_INVALID_SIZED_NAME = "이름은 %d글자 이상, %d글자 이하여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_NULL_NAME = "올바른 이름을 입력해주세요";

    private final String name;
    private int position;

    public Car(String name) {
        validateNotNull(name);
        String trimmedName = trim(name);
        validateLength(trimmedName);

        this.name = trimmedName;
    }

    private static void validateNotNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NULL_NAME);
        }
    }

    private static String trim(String name) {
        return name.trim();
    }

    private static void validateLength(final String name) {
        if (name.length() < MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(
                String.format(ERROR_MESSAGE_FOR_INVALID_SIZED_NAME, MINIMUM_LENGTH, MAXIMUM_LENGTH));
        }
    }

    public void advance(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            this.position++;
        }
    }

    public boolean isEqualPosition(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car)o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
    }
}
