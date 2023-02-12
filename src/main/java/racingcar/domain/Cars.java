package racingcar.domain;

import racingcar.domain.constant.CarConstant;
import racingcar.exception.DuplicateException;
import racingcar.util.NumberGenerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.domain.constant.CarsConstant.SPLIT_DELIMITER;
import static racingcar.enumType.ExceptionMessage.DUPLICATE_MESSAGE;

public class Cars {

    private final List<Car> cars;

    private final NumberGenerator numberGenerator;

    private Cars(final String carNames, final NumberGenerator numberGenerator) {
        this.cars = createCars(carNames);
        this.numberGenerator = numberGenerator;
        validateDuplicateCarName();
    }

    public static Cars createCars(final String carNames, final NumberGenerator numberGenerator) {
        return new Cars(carNames, numberGenerator);
    }

    public void race() {
        cars.forEach(car -> {
            int power = numberGenerator.generate();
            car.move(power);
        });
    }

    public List<String> pickWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Car> createCars(final String carNames) {
        String[] names = splitCarNames(carNames);
        return Arrays.stream(names)
                .map(Car::createCar)
                .collect(Collectors.toList());
    }

    private String[] splitCarNames(final String carNames) {
        return carNames.split(SPLIT_DELIMITER.getValue());
    }

    private void validateDuplicateCarName() {
        int uniqueCarCount = new HashSet<>(cars).size();
        if (cars.size() != uniqueCarCount) {
            throw new DuplicateException(DUPLICATE_MESSAGE.getValue());
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(CarConstant.INIT_POSITION.getValue());
    }

    @Override
    public boolean equals(Object diffCars) {
        if (this == diffCars) return true;
        if (diffCars == null || getClass() != diffCars.getClass()) return false;
        Cars cars = (Cars) diffCars;
        return Objects.equals(this.cars, cars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
