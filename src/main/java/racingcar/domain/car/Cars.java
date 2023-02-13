package racingcar.domain.car;

import racingcar.domain.game.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_SIZE = 2;

    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        if (carNames.size() < MIN_SIZE) {
            throw new IllegalArgumentException("자동차는 2대 이상 존재해야 합니다.");
        }
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> cars() {
        return this.cars;
    }

    public void move(final NumberGenerator numberGenerator) {
        cars.forEach(it -> it.move(numberGenerator));
    }
}
