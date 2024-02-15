package racingcar.model;

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
        if (moveCount <= 0 || moveCount > MAX_MOVE_COUNT ) {
            throw new IllegalArgumentException("시도할 회수는 1~300 사이입니다.");
        }
    }

    public boolean isGameOver() {
        return moveCount-- <= 0;
    }

    public void move(CarMoveRule carMoveRule) {
        cars.stream()
                .filter(car -> carMoveRule.isGo())
                .forEach(Car::move);
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
