package racingcar.domain;

import racingcar.util.RaceNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.enumType.DomainConstant.CAR_FORWARD_NUMBER;

public class Cars {

    private final List<Car> cars;

    private final RaceNumberGenerator numberGenerator;

    private Cars(String carNames) {
        numberGenerator = new RaceNumberGenerator();
        this.cars = splitCarNames(carNames);
    }

    public static Cars of(String carNames) {
        return new Cars(carNames);
    }

    private List<Car> splitCarNames(String carNames) {
        String[] names = carNames.split(",");
        return Arrays.stream(names)
                .map(Car::of)
                .collect(Collectors.toList());
    }

    public String initStatus() {
        StringBuilder result = new StringBuilder();
        this.cars.forEach(car -> result.append(car).append("\n"));
        return result.toString();
    }

    public String race() {
        StringBuilder result = new StringBuilder();
        this.cars.forEach(car -> {
            checkNumberAndMove(car);
            result.append(car).append("\n");
        });
        return result.toString();
    }

    public void checkNumberAndMove(Car car) {
        int randomNumber = numberGenerator.generate();
        if (randomNumber >= CAR_FORWARD_NUMBER.getValue()) {
            car.move();
        }
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
