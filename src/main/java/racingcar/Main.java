package racingcar;

import racingcar.Controller.Game;
import racingcar.Model.Car;
import racingcar.Model.GameResult;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.List;

/**
 * 클래스 이름 : Main.java
 *
 * @author 작은곰
 * @version 1.0.1
 * <p>
 * 날짜 : 2020.02.16 일요일
 */

public class Main {
    private static final int INDEX_START = 0;

    public static void main(String[] args) {
        List<Car> cars = InputView.inputCarName();
        int tryNo = InputView.inputTrialTime().getTrialTime();
        Game.initialize(cars);

        OutputView.printResultMessage();
        for (int index = INDEX_START; index < tryNo; index++) {
            GameResult result = Game.race();
            result.printResult();
            OutputView.printNewLine();
        }

        OutputView.printWinners(Game.showWinner());
    }
}
