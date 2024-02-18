package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarNames(cars);
        this.cars = cars;
    }

    public void makeCarMove(RandomNumberGenerator generator) {
        cars.forEach(car -> car.move(generator.generate()));
    }

    public RoundResult getRoundResult() {
        Map<CarName, Position> carStatus = new LinkedHashMap<>();
        for (Car car : cars) {
            carStatus.put(car.getCarName(), car.getPosition());
        }
        return new RoundResult(carStatus);
    }

    private void validateCarNames(List<Car> cars) {
        Set<CarName> distinctNames = cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toUnmodifiableSet());
        if (distinctNames.size() != cars.size()) {
            String message = "자동차 이름은 중복될 수 없습니다.";
            throw new IllegalArgumentException(message);
        }
    }
}
