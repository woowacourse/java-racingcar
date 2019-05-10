package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) {
        if (StringUtils.isBlank(name) || name.length() > Const.MAX_NAME_LEN) {
            throw new IllegalArgumentException(Const.EX_NAME_LEN);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void increasePositionOrNot(int randomNumber) {
        if (Const.GO_RAN_NUM <= randomNumber) {
            this.position++;
        }
    }

    public boolean isGreaterThanMaxPosition(int maxPosition) {
        return this.position > maxPosition;
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
}
