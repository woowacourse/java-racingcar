package racingcar.domain.vo;

import java.util.Objects;

public class CarStatus {
    private final String name;
    private final int position;

    private CarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static CarStatus of(String name, int position) {
        return new CarStatus(name, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatus carStatus = (CarStatus) o;
        return position == carStatus.position && Objects.equals(name, carStatus.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
