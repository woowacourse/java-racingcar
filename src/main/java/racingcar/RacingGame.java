package racingcar;

import java.util.List;

public class RacingGame {

    private final RacingCars racingCars;
    private int leftCount;

    public RacingGame(RacingCars racingCars, int leftCount) {
        this.racingCars = racingCars;
        checkPositiveCount(leftCount);
        this.leftCount = leftCount;
    }

    private void checkPositiveCount(int leftCount) {
        if (leftCount <= 0) {
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
        return leftCount == 0;
    }

    public List<String> winnerNames() {
        return racingCars.calculateWinnerNames();
    }
}
