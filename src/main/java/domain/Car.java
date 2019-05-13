package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        if (StringUtils.isBlank(name) || name.length() > Const.MAX_NAME_LEN) {
            throw new IllegalArgumentException(Const.EX_NAME_LEN);
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int increasePositionOrNot(int randomNumber) {
        if (Const.GO_RAN_NUM <= randomNumber) {
            this.position++;
            return 1;
        }
        return 0;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
