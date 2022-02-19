package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_POSITION = 0;
    private static final String CAR_NAME_ERROR_MESSAGE = "자동차 이름이 null이거나 빈 문자열, 혹은 공백으로만 이루어져 있습니다.";

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        carNames.forEach(this::carNameCheck);
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void proceedAll() {
        cars.forEach(car -> car.proceed(new RandomProceedStrategy()));
    }

    public List<Car> getCarsHere(int positions) {
        return cars.stream()
                .filter(car -> car.isHere(positions))
                .collect(Collectors.toList());
    }

    public List<CarDto> toCarDtos() {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }

    private void carNameCheck(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }
}
