package racingcar.model;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CarName carName = (CarName) obj;
        return this.name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
