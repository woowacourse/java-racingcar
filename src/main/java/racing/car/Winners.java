package racing.car;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

    public static final String COMMA = ", ";
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public String combine() {
        List<String> winnersNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(COMMA, winnersNames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners = (Winners) o;
        return Objects.equals(cars, winners.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
