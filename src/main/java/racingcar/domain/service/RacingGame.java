package racingcar.domain.service;

import java.util.List;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;
import racingcar.domain.rules.CarMoveRule;

public class RacingGame {

    private static final int MAX_MOVE_COUNT = 300;
    private final Cars cars;
    private int moveCount;

    public RacingGame(Cars cars, int moveCount) {
        validate(moveCount);
        this.cars = cars;
        this.moveCount = moveCount;
    }

    private void validate(int moveCount) {
        if (moveCount <= 0 || moveCount > MAX_MOVE_COUNT) {
            throw new IllegalArgumentException("시도할 회수는 1~300 사이입니다.");
        }
    }

    public boolean isRoundInProgress() {
        decreaseMoveCount();
        return !isGameOver();
    }
    private boolean isGameOver() {
        return moveCount <= 0;
    }
    private void decreaseMoveCount() {
        this.moveCount--;
    }

    public void move(CarMoveRule carMoveRule) {
        cars.stream().filter(car -> carMoveRule.isGo()).forEach(Car::move);
    }

    public Cars findWinners() {
        int maxProgress = cars.getMaxProgress();
        return new Cars(filterWinningCars(maxProgress));
    }


    private List<Car> filterWinningCars(int maxProgress) {
        return cars.stream()
                .filter(car -> car.isEqualToProgress(maxProgress))
                .toList();
    }
}
