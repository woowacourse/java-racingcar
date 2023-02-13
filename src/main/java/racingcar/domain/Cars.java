package racingcar.domain;

import java.util.Arrays;
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
        Car winner = cars.stream().max(Car::compareTo).get();

        return cars.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
