package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_CONDITION = 4;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String INPUT_CAR_NAME_ERROR = "올바른 자동차 이름을 입력해주세요";
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";

    private int position = 0;
    private final String name;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        if (name.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_ERROR);
        }

        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_ERROR);
        }

        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_ERROR);
        }

        this.name = name;
        this.position = position;
    }

    public Car move(int number) {
        if (number >= MOVE_CONDITION) {
            position++;
        }
        return this;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getCurrentPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + COLON);
        for (int i = 0; i < position; i++) {
            sb.append(HYPHEN);
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
        return Objects.hash(position, name);
    }

}
