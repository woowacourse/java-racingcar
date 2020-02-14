package racinggame.race.car;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class Winners {
    public static final String COMMA = ", ";

    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public String getNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(joining(COMMA));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners = (Winners) o;
        return Objects.equals(cars, winners.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
