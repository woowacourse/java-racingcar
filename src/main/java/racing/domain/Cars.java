package racing.domain;

import racing.domain.dto.CarDto;
import racing.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int SPLIT_THRESHOLD = -1;
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int MINIMUM_CAR_COUNTS = 2;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        validateCars();
    }

    public static Cars generate(String carNames) {
        String[] splitCarNames = splitCarNames(carNames);
        List<Car> cars = Arrays.stream(splitCarNames)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.split(DELIMITER, SPLIT_THRESHOLD);
    }

    private void validateCars() {
        if (cars.size() < MINIMUM_CAR_COUNTS) {
            throw new IllegalArgumentException();
        }
    }

    public void race() {
        cars.forEach(car -> car.move(RandomUtils.getRandomNumber(START_NUMBER, END_NUMBER)));
    }

    public List<String> findWinnerNames() {
        int maxPosition = getMaxPosition();
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        return winners;
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(IllegalStateException::new)
                .getPosition();
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }
}
