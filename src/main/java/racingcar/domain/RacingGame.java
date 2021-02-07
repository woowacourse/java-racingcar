package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static final String ROUND_MUST_POSITIVE_ERROR_MSG_FORMAT = "[ERROR] 라운드 수는 음수일 수 없습니다. 입력받은 라운드 수 : %d";

    private final Cars cars;
    private final int goalRound;

    public RacingGame(List<String> names, int goalRound) {
        validateTargetRound(goalRound);
        this.cars = Cars.createCarsByNames(names);
        this.goalRound = goalRound;
    }

    public RacingGame(Cars cars, int goalRound) {
        validateTargetRound(goalRound);
        this.cars = cars;
        this.goalRound = goalRound;
    }

    private void validateTargetRound(int goalRound) {
        if (goalRound < 0) {
            throw new IllegalArgumentException(String.format(ROUND_MUST_POSITIVE_ERROR_MSG_FORMAT, goalRound));
        }
    }

    public void playRound() {
        cars.moveCars();
    }

    public boolean isEnd() {
        return cars.isEnd(goalRound);
    }

    public GameResult findWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars;
    }

    public int getCurrentRound() {
        return cars.getCurrentRound();
    }
}
