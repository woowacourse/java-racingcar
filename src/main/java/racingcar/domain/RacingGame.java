package racingcar.domain;

import java.util.List;

public class RacingGame {
    private static final String ROUND_MUST_POSITIVE_ERROR_MSG_FORMAT = "[ERROR] 라운드 수는 음수일 수 없습니다. 입력받은 라운드 수 : %d";
    private static final int ONE = 1;

    private final Cars cars;
    private final Round goalRound;
    private final Round currentRound;

    public RacingGame(List<String> names, int goalRound) {
        this(Cars.createCarsByNames(names),goalRound);
    }

    public RacingGame(Cars cars, int goalRound) {
        validateTargetRound(goalRound);
        this.cars = cars;
        this.goalRound = new Round(goalRound);
        this.currentRound = new Round(ONE);
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
        return currentRound.isBiggerThan(goalRound);
    }

    public GameResult findWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars;
    }

    public Round getCurrentRound() {
        return currentRound;
    }
}
