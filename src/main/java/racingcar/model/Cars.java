package racingcar.model;

import static racingcar.utils.validator.CarNamesValidator.validateDuplicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.utils.RandomNumber;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        cars = createCars(validateDuplicate(carNames));
    }

    private List<Car> createCars(final String[] carNames) {
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        cars.forEach(car -> car.move(RandomNumber.generate()));
    }

    public List<Car> getWinners() {
        return cars.stream()
            .filter(car -> car.isMaxPosition(findMaxPosition()))
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}
