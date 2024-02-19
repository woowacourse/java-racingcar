package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    public Map<Car, Integer> tryMoveAll() {
        Map<Car, Integer> result = new LinkedHashMap<>();
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
            result.put(car, car.getPosition());
        }

        return result;
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<Car> getCarsByPosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .toList();
    }

    private void validateDuplicate(List<Car> cars) {
        Set<String> distinctNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (distinctNames.size() != cars.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 있습니다.");
        }
    }
}
