package racingcar.Model;

import racingcar.View.OutputView;

import java.util.List;

/**
 * 클래스 이름 : GameResult.java
 *
 * @author 작은곰
 * @version 1.0.2
 * <p>
 * 날짜 : 2020.02.17 월요일
 */

public class GameResult {
    private List<Car> result;

    public GameResult(List<Car> result) {
        this.result = result;
    }

    public void printResult() {
        for (Car car : result) {
            OutputView.printPositionByDash(car);
        }
    }
}
