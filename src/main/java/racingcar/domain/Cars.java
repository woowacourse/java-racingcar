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

    private Cars(final String carNames, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.cars = createCars(carNames);
        validateDuplicateCarName();
    }

    public static Cars of(final String carNames, NumberGenerator numberGenerator) {
        return new Cars(carNames, numberGenerator);
    }

    public List<CarRaceDto> initStatus() {
        return cars.stream()
                .map(car -> CarRaceDto.of(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<CarRaceDto> race() {
        return cars.stream().map(car -> {
            int randomNumber = numberGenerator.generate();
            car.move(randomNumber);
            return CarRaceDto.of(car.getName(), car.getPosition());
        }).collect(Collectors.toList());
    }

    public List<String> pickWinners() {
        return cars.stream()
                .filter(car -> Objects.equals(car.getPosition(), getMaxDistance()))
                .map(Car::getName)
                .collect(Collectors.toList());
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
        int nonDuplicateCount = new HashSet<>(cars).size();
        if (cars.size() != nonDuplicateCount) {
            throw new DuplicateException(DUPLICATE_MESSAGE.getValue());
        }
    }

    private Integer getMaxDistance() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(INIT_POSITION.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
