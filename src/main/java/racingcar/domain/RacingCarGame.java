package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarGame {
    public static final String CAR_NAME_DELIMITER = ",";

    private final Cars cars;
    private Count count;

    public RacingCarGame(final String input, final MoveStrategy moveStrategy) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. String 타입을 이용하세요.");
        }
        if (Objects.isNull(moveStrategy)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. MoveStrategy 타입을 이용하세요.");
        }

        this.cars = makeCars(input, moveStrategy);
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
        count.decrease();
    }

    public boolean canPlay() {
        return count.hasRemaining();
    }

    public List<Car> getWinners() {
        if (canPlay()) {
            throw new IllegalStateException("게임이 끝나지 않았습니다.");
        }
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.get();
    }

    public void setCount(final Count count) {
        this.count = count;
    }
}
