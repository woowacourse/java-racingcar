package domain;

import java.util.Objects;

public class Car {
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int MAX_MOVE_NUMBER = 9;
    private static final int MIN_STOP_NUMBER = 0;
    private static final int NAME_MAX_LENGTH  = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validName(name);

        this.name = name;
        this.position = position;
    }

    private void validName(String name) {
        if ((name.length() > NAME_MAX_LENGTH) || (name.length() < 1)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하 입니다.");
        }
    }

    public int judgeMove(int number) {
        if (number > MAX_MOVE_NUMBER || number < MIN_STOP_NUMBER) {
            return -1;
        }

        if (number >= MIN_MOVE_NUMBER) {
            position++;
            return 1;
        }

        return 0;
    }

    public int getBiggerPosition(int position) {
       return Math.max(this.position, position);
    }

    public boolean isEqualPosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
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
