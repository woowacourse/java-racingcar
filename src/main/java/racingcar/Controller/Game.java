package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

/**
 * 클래스 이름 : Game.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.13 목요일
 */

public class Game {
    private static final int INDEX_START = 0;

    private static List<Car> cars = new ArrayList<>();
    private static int trialTime;

    public static void initialize() {
        List<String> carNames = InputView.inputCarName();
        carNames.forEach(carName -> cars.add(new Car(carName)));
        trialTime = InputView.inputTrialTime();
    }

    public static void race() {
        OutputView.printResultMessage();
        for (int index = INDEX_START; index < trialTime; index++) {
            raceOneRound();
            OutputView.printNewLine();
        }
    }

    private static void raceOneRound() {
        for (Car car : cars) {
            car.goOrNot();
            car.showCurrentPosition();
        }
    }

    public static void showWinner() {
        Car topPositionCar = findTopPositionCar(cars);
        for (Car car : cars) {
            topPositionCar.findWinners(car);
        }
        OutputView.printWinners(topPositionCar.getWinners());
    }

    public static Car findTopPositionCar(List<Car> cars) {
        Car winner = cars.get(0);
        int carSize = cars.size();
        if (carSize == 1) {
            return winner;
        }
        for (int i = 1; i < carSize; i++) {
            if (!winner.comparePosition(cars.get(i))) {
                winner = cars.get(i);
            }
        }
        return winner;
    }

}
