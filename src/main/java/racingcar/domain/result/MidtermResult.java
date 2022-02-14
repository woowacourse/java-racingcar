package racingcar.domain.result;

import static java.util.stream.Collectors.toUnmodifiableMap;

import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.exception.NotFoundCarNameException;

public class MidtermResult {

    private final Map<String, Integer> cars;

    public MidtermResult(List<Car> cars) {
        this.cars = cars.stream()
            .collect(toUnmodifiableMap(Car::getName, Car::getPosition));
    }

    public int getPositionByName(String name) {
        if (!cars.containsKey(name)) {
            throw new NotFoundCarNameException(name);
        }
        return cars.get(name);
    }

    public Set<String> getCarNames() {
        return cars.keySet();
    }
}
