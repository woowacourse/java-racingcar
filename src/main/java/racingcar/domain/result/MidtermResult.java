package racingcar.domain.result;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.Car;

public class MidtermResult {
    private final List<Car> cars;

    public MidtermResult(List<Car> cars) {
        this.cars = cars;
    }

    public int getPositionByName(String name) {
        return findCarByName(name).getPosition();
    }

    private Car findCarByName(String name) {
        return cars.stream().filter(c -> c.getName().equals(name)).findFirst().get();
    }

    public List<String> getCarNames() {
        return cars.stream().map(Car::getName).collect(toList());
    }
}
