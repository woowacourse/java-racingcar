package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    public static final String CAR_NAME_DELIMITER = ",";

    private Cars cars;

    public RacingCarGame(final String input, final MoveStrategy moveStrategy) {
        checkNull(input, moveStrategy);
        makeCars(input, moveStrategy);
    }

    private void checkNull(final String input, final MoveStrategy moveStrategy) {
        checkInputIsNull(input);
        checkMoveStrategyIsNull(moveStrategy);
    }

    private void checkMoveStrategyIsNull(final MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new IllegalArgumentException("null이 사용될수 없습니다. MoveStrategy 타입을 이용하세요.");
        }
    }

    private void checkInputIsNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값은 null이 될수 없습니다.");
        }
    }

    private void makeCars(final String input, final MoveStrategy moveStrategy) {
        final List<Car> cars = Arrays.stream(input.split(CAR_NAME_DELIMITER))
            .map(CarName::new)
            .map(Car::new)
            .collect(Collectors.toList());
        this.cars = new Cars(cars, moveStrategy);
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

    public List<Car> getCars() {
        return cars.get();
    }

    public void playRound() {
        cars.attemptToMoveCars();
    }
}
