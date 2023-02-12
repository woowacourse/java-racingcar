package racingcar.domain;

import racingcar.domain.dto.CarRaceDto;
import racingcar.exception.DuplicateException;
import racingcar.util.NumberGenerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.domain.constant.CarConstant.INIT_POSITION;
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

    public static Cars of(final String carNames, final NumberGenerator numberGenerator) {
        return new Cars(carNames, numberGenerator);
    }

    private List<Car> createCars(String carNames) {
        String[] names = splitCarNames(carNames);
        return Arrays.stream(names)
                .map(Car::of)
                .collect(Collectors.toList());
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(SPLIT_DELIMITER.getValue());
    }

    private void validateDuplicateCarName() {
        int uniqueCarCount = new HashSet<>(cars).size();
        if (cars.size() != uniqueCarCount) {
            throw new DuplicateException(DUPLICATE_MESSAGE.getValue());
        }
    }

    public List<CarRaceDto> initStatus() {
        return cars.stream()
                .map(Car::getCarRaceResult)
                .collect(Collectors.toList());
    }

    public List<CarRaceDto> race() {
        return cars.stream().map(car -> {
            int power = numberGenerator.generate();
            car.move(power);
            return car.getCarRaceResult();
        }).collect(Collectors.toList());
    }

    public List<String> pickWinners() {
        return cars.stream()
                .filter(car -> car.isSamePosition(getMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(INIT_POSITION.getValue());
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
}
