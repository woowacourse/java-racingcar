package racingcar.domain;

import java.util.List;

public class Car {
    public static final String NAME_MUSTBE_1TO5 = "이름은 1자 이상 5자 이하여야 합니다.";
    public static final String RANDOM_OUTOF_BOUND = "범위를 초과한 난수입니다.";
    public static final int ZERO = 0;
    public static final int RANDOM_MAX = 9;
    public static final int THRESHOLD = 4;
    public static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_MUSTBE_1TO5);
        }
        this.name = name;
    }

    public boolean canMove(int i) {
        if (i < ZERO || i > RANDOM_MAX) {
            throw new NumberFormatException(RANDOM_OUTOF_BOUND);
        }
        if (i >= THRESHOLD) {
            return true;
        }
        return false;
    }

    public void proceed() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car comparePosition(Car car) {
        if (car.position > this.position) {
            return car;
        }
        return this;
    }
}
