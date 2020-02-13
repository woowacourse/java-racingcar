package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_NAME_MESSAGE = "중복된 이름이 있습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateNames(cars);
        this.cars = cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    public List<Car> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    public int getSize() {
        return cars.size();
    }

    private void validateDuplicateNames(List<Car> cars) {
        boolean isDuplicated =cars.stream()
                .distinct()
                .count() != cars.size();

        if (isDuplicated) {
            throw new IllegalArgumentException(DUPLICATED_NAME_MESSAGE);
        }
    }
}
