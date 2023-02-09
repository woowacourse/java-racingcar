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

    public String pickWinners() {
        StringBuilder winners = new StringBuilder();
        List<String> carNames = this.cars.stream()
                .filter(car -> Objects.equals(car.getDrivingDistance().getDistance(), getMaxDistance()))
                .map(Car::getName)
                .collect(Collectors.toList());
        return winners.append(String.join(", ", carNames)).toString();
    }

    private Integer getMaxDistance() {
        return this.cars.stream()
                .mapToInt(car -> car.getDrivingDistance().getDistance())
                .max().orElse(1);
    }

    public String race() {
        StringBuilder result = new StringBuilder();
        this.cars.forEach(car -> {
            int randomNumber = numberGenerator.generate();
            checkNumberAndMove(car, randomNumber);
            result.append(car).append("\n");
        });
        return result.toString();
    }

    private void checkNumberAndMove(Car car, int randomNumber) {
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
