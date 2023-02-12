package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_NAMES_DELETMETER = ",";

    private static final String CAR_ERROR = "[ERROR] 차량 리스트가 비었습니다";

    private final List<Car> cars;

    public Cars(String carNames) {
        String[] split = carNames.split(CAR_NAMES_DELETMETER);
        this.cars = Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinnerNames() {
        int highestPosition = getHighestPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getHighestPosition() {
        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);
        Car carWithMaxPosition = cars.stream()
                .max(comparatorByPosition)
                .orElseThrow(() -> new IllegalArgumentException(CAR_ERROR));
        return carWithMaxPosition.getPosition();
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
