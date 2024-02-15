package racingcar.model;

public class RacingGame {

    private final Cars cars;
    private int moveCount;

    public RacingGame(Cars cars, int moveCount) {
        validate(moveCount);
        this.cars = cars;
        this.moveCount = moveCount;
    }

    private void validate(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("시도할 회수는 0이상입니다.");
        }
    }

    public boolean isGameOver(){
        return moveCount-- <= 0;
    }

    public void move(RaceRule raceRule) {
        cars.stream()
                .filter(car -> raceRule.isGo())
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
