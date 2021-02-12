package racingcar.domain;

import racingcar.utils.RacingCarUtils;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarGame {
    private Cars cars;
    private TryCount tryCount;
    private boolean isRacing = true;
    private int raceCount;

    public Cars getCars() {
        return cars;
    }

    public boolean isRacing() {
        return isRacing;
    }

    public List<String> getWinnersNames() {
        return new Winners(cars).getWinnersNames();
    }

    public void racingCarGameSetting() {
        cars = new Cars(getCarNames());
        tryCount = new TryCount(InputView.getTryCountInput());
    }

    private List<String> getCarNames() {
        return RacingCarUtils.splitInputString(InputView.getCarNameInput());
    }

    public void racing() {
        if (this.raceCount <= tryCount.getCount()) {
            moveMovableCar();
            raceCount++;
            return;
        }
        isRacing = false;
    }

    private void moveMovableCar() {
        cars.moveCars();
    }
}
