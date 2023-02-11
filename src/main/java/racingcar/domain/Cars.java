package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_ERROR = "[ERROR] 차량 리스트가 비었습니다";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinnerNames() {
        int highestPosition = getHighestPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getHighestPosition() {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

        Car carWithMaxPosition = cars.stream()
                .max(comparatorByPosition)
                .orElseThrow(() -> new IllegalArgumentException(CAR_ERROR));

        return carWithMaxPosition.getPosition();
    }

}
