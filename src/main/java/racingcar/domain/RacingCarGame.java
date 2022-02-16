package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RacingCarGame {
    public static final String CAR_NAME_DELIMITER = ",";

    private final Cars cars;

    public RacingCarGame(final String input, final MoveStrategy moveStrategy) {
        final String noneNullInput = Optional.ofNullable(input)
                .orElseThrow(() -> new IllegalArgumentException("null은 사용할 수 없습니다. String 타입을 이용하세요."));

        final MoveStrategy noneNullMoveStrategy = Optional.ofNullable(moveStrategy)
                .orElseThrow(() -> new IllegalArgumentException("null은 사용할 수 없습니다. MoveStrategy 타입을 이용하세요."));

        this.cars = makeCars(noneNullInput, noneNullMoveStrategy);
    }

    private Cars makeCars(final String input, final MoveStrategy moveStrategy) {
        final List<Car> cars = Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(CarName::new)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars, moveStrategy);
    }

    public void playRound() {
        cars.attemptToMoveCars();
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.get();
    }
}
