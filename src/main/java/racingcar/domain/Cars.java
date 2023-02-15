package racingcar.domain;

import racingcar.exception.DuplicateException;
import racingcar.exception.NoResourceException;
import racingcar.util.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.domain.constant.CarsConstant.SPLIT_DELIMITER;
import static racingcar.enumType.ExceptionMessage.DUPLICATE_MESSAGE;
import static racingcar.enumType.ExceptionMessage.NO_RESOURCE_MESSAGE;

public class Cars {

    private final List<Car> cars;

    private final NumberGenerator numberGenerator;

    private Cars(final String carNames, final NumberGenerator numberGenerator) {
        this.cars = create(carNames);
        this.numberGenerator = numberGenerator;
        validateDuplicateCarName();
    }

    public static Cars create(final String carNames, final NumberGenerator numberGenerator) {
        return new Cars(carNames, numberGenerator);
    }

    public void race() {
        cars.forEach(car -> {
            int power = numberGenerator.generate();
            car.move(power);
        });
    }

    public Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoResourceException(String.format(NO_RESOURCE_MESSAGE.getValue(), "차량 리스트")));
    }

    private List<Car> create(final String carNames) {
        String[] names = splitCarNames(carNames);
        return Arrays.stream(names)
                .map(Car::create)
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
        return Collections.unmodifiableList(cars);
    }
}
