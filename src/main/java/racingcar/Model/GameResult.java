package racingcar.Model;

import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<Car> result = new ArrayList<>();

    public GameResult(List<Car> result) {
        this.result = result;
    }

    public void printResult() {
        for(Car car : result) {
            OutputView.printPositionByDash(car);
        }
    }
}
