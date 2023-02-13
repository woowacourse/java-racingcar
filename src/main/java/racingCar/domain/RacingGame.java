package racingCar.domain;

import racingCar.util.RepeaterUtil;
import racingCar.view.InputView;
import racingCar.view.OutputView;
import java.util.List;

public class RacingGame {

    private static final int MIN_TRY_COUNT = 1;

    private Cars cars;
    private int tryCount;

    public void play() {
        RepeaterUtil.run(this::generateCars);
        RepeaterUtil.run(this::readTryCount);
        playRacing(cars, tryCount);
        OutputView.printWinners(cars.findWinners());
    }

    private void generateCars() {
        List<String> carNames = RepeaterUtil.repeat(InputView::readCarNames);
        this.cars = new Cars(carNames);
    }

    private void readTryCount() {
        this.tryCount = RepeaterUtil.repeat(InputView::readTryCount);
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다");
        }
    }

    private void playRacing(Cars cars, int tryCount) {
        for (int count = 1; count <= tryCount; count++) {
            cars.move();
            OutputView.printRacing(cars.getCars());
        }
    }
}
