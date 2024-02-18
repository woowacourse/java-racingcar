package racingcar.domain;

public class CarRacingGame {

    private static final int MIN_MOVE_COUNT = 1;
    private static final int MAX_MOVE_COUNT = 300;

    private final Cars cars;
    private int moveCount;

    public CarRacingGame(Cars cars, int moveCount) {
        validate(moveCount);
        this.cars = cars;
        this.moveCount = moveCount;
    }

    private void validate(int moveCount) {
        if (moveCount < MIN_MOVE_COUNT || moveCount > MAX_MOVE_COUNT) {
            throw new IllegalArgumentException(
                    "시도할 회수는 %d~%d 사이입니다.".formatted(MIN_MOVE_COUNT, MAX_MOVE_COUNT)
            );
        }
    }

    public void proceed(CarMoveRule carMoveRule) {
        decreaseMoveCount();
        moveCars(carMoveRule);
    }

    private void decreaseMoveCount() {
        if (moveCount < MIN_MOVE_COUNT) {
            throw new IllegalArgumentException("시도 횟수를 모두 사용했습니다.");
        }
        moveCount--;
    }

    private void moveCars(CarMoveRule carMoveRule) {
        cars.stream()
                .filter(car -> carMoveRule.isGo())
                .forEach(Car::move);
    }

    public boolean isGameOver() {
        return moveCount < MIN_MOVE_COUNT;
    }

    public Cars findWinners() {
        int maxProgress = cars.stream()
                .map(Car::getProgress)
                .reduce(Integer::max)
                .orElse(0);
        return new Cars(cars.stream()
                .filter(car -> car.getProgress() == maxProgress)
                .toList());
    }
}
