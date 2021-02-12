package racingcar.domain;

import racingcar.utils.RacingCarUtils;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {
    private final Cars cars;
    private int tryCount;
    private boolean isRacing = true;

    public RacingCarGame() {
        cars = new Cars(getCarNames());
        tryCount = new TryCount(InputView.getTryCountInput()).value();
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isRacing() {
        return isRacing;
    }

    public List<String> getWinnersNames() {
        return new Winners(cars).getWinnersNames();
    }


    private List<String> getCarNames() {
        return RacingCarUtils.splitInputString(InputView.getCarNameInput());
    }

    public void racing() {
        if (tryCount-- > 0) {
            moveMovableCar();
            return;
        }
        isRacing = false;
    }

    private void moveMovableCar() {
        cars.moveCars();
    }
}
