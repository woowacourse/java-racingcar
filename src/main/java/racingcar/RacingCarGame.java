package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.utils.RacingCarUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarGame {
    private Cars cars;
    private TryCount tryCount;

    public void run() {
        racingCarSetting();
        racing();
        pickWinners();
    }

    private void racingCarSetting() {
        cars = new Cars(getCarNames());
        tryCount = new TryCount(InputView.getTryCountInput());
    }

    private List<String> getCarNames() {
        return RacingCarUtils.splitInputString(InputView.getCarNameInput());
    }

    private void racing() {
        for (int i = 0; i < tryCount.getCount(); i++) {
            moveMovableCar();
            ResultView.printProgressResult(cars.getCars());
        }
    }

    private void moveMovableCar() {
        cars.moveCars();
    }

    private void pickWinners() {
        Winners winners = new Winners(cars);
        ResultView.printFinalResult(winners.getWinnersNames());
    }
}
