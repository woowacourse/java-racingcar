package racingCar.domain;

import racingCar.view.OutputView;
import java.util.List;

public class RacingGame {

    private final static int MIN_TRY_COUNT = 1;

    private Cars cars;
    private int tryCount;

    public void play(List<String> carNames, int tryCount) {
        this.cars = new Cars(carNames);
        validate(tryCount);
        this.tryCount = tryCount;

        race();
    }

    private void validate(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도횟수는 1회 이상이어야 합니다.");
        }
    }

    private void race() {
        for (int count = 1; count <= tryCount; count++) {
            cars.move();
            OutputView.printRacing(cars.getStates());
        }
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }
}
