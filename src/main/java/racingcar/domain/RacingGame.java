package racingcar.domain;

import java.util.List;
import racingcar.view.Validator;

public class RacingGame {

    private static final int END_COUNT = 0;

    private final RacingCars racingCars;
    private int leftCount;

    public RacingGame(RacingCars racingCars, int leftCount) {
        this.racingCars = racingCars;
        Validator.checkTryCountPositive(leftCount);
        this.leftCount = leftCount;
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
