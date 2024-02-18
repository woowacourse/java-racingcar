package racingcar.domain.car;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.result.RoundResult;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<CarName> carNames) {
        validateDuplicateName(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public static Cars from(final List<CarName> carNames) {
        return new Cars(carNames);
    }

    private void validateDuplicateName(final List<CarName> carNames) {
        if (carNames.size() != Set.copyOf(carNames).size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.");
        }
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

    public RoundResult getRoundResult() {
        return RoundResult.from(cars);
    }
}
