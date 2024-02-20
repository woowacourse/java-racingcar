package domain;

import java.util.Objects;

public class Car {
    private static final int MINIMUM_CAR_NAME_LENGTH = 0;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_DRIVING_POWER = 4;
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        position = 0;
        this.name = name;
    }

    private void validate(String name) {
        if (!validateRange(name)) {
            throw new IllegalArgumentException("1이상 5이하의 이름을 입력하세요.");
        }
    }

    private boolean validateRange(String name) {
        return name.length() > MINIMUM_CAR_NAME_LENGTH && name.length() <= MAXIMUM_CAR_NAME_LENGTH;
    }

    public void execute(int power) {
        if (power >= MINIMUM_DRIVING_POWER) {
            this.move();
        }
    }

    private void move() {
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Car) obj;
        return Objects.equals(this.name, that.name) &&
                this.position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
