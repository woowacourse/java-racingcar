package racingcar.vo;

import java.util.Objects;

public class CarValue {
    private final String name;
    private final int position;

    public CarValue(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarValue create(String name, int position) {
        return new CarValue(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarValue)) {
            return false;
        }
        CarValue carValue = (CarValue)o;
        return position == carValue.position && Objects.equals(name, carValue.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
