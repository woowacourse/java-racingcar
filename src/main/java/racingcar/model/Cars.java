package racingcar.model;

import java.util.Comparator;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final CarNames carNames) {
        final List<Car> cars = carNames.getCarNames().stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public void go(final NumberGenerator generator) {
        cars.forEach(car -> car.go(generator.generate()));
    }

    public List<String> findWinners() {
        final Car winnerCar = findWinner();

        return cars.stream()
                .filter(car -> car.isSamePosition(winnerCar))
                .map(Car::getName)
                .toList();
    }

    private Car findWinner() {
        return cars.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException("[ERROR] 우승자를 찾을 수 없습니다."));
    }

    public RoundResult getRacingGameResult() {
        final List<CarResult> carResults = cars.stream()
                .map(CarResult::from)
                .toList();

        return new RoundResult(carResults);
    }
}
