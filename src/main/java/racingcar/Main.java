package racingcar;

import racingcar.Controller.Game;
import racingcar.Model.Car;
import racingcar.View.InputView;

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
    public static void main(String[] args) {
        List<Car> cars = InputView.inputCarName();
        int tryNo = InputView.inputTrialTime().getTrialTime();
        Game.initialize(cars, tryNo);
        Game.race();
        Game.showWinner();
    }
}
