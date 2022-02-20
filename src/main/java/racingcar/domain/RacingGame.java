package racingcar.domain;

import java.util.List;

public class RacingGame {

    private static int MIN_TRY_COUNT = 1;
    private static final int END_COUNT = 0;

    private final RacingCars racingCars;
    private int leftCount;

    public RacingGame(final RacingCars racingCars, final int leftCount) {
        this.racingCars = racingCars;
        checkLeftCountPositive(leftCount);
        this.leftCount = leftCount;
    }

    private void checkLeftCountPositive(final int leftCount) {
        if (leftCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도횟수는 0이하의 값이 들어올 수 없다.");
        }
    }

    public void race() {
        checkCanRace();
        racingCars.moveCars();
        leftCount--;
    }

    private void checkCanRace() {
        if (isEnd()) {
            throw new RuntimeException("종료된 게임은 더이상 실행할 수 없다.");
        }
    }

    public boolean isEnd() {
        return leftCount == END_COUNT;
    }

    public List<String> getWinnerNames() {
        return racingCars.searchWinnerNames();
    }
}
