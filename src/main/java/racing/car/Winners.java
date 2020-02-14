package racing.car;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

    private static final String CANNOT_FIND_MAX_DISTANCE_MESSAGE = "가장 멀리 간 자동차의 거리를 구할 수 없습니다.";

    private final Cars cars;

    public Winners(Cars cars) {
        int max = getMaxDistance(cars);
        this.cars = new Cars(getWinnerByMaxDistance(cars, max));
    }

    private int getMaxDistance(Cars cars) {
        return cars.getCars().stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new AssertionError(CANNOT_FIND_MAX_DISTANCE_MESSAGE));
    }

    private List<Car> getWinnerByMaxDistance(Cars cars, int max) {
        return cars.getCars().stream()
                .filter(car -> car.isWinner(max))
                .collect(Collectors.toList());
    }

    public Cars getCars() {
        return cars;
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
