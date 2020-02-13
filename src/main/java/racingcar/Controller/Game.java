package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        String[] carNames = InputView.inputCarName();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
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

    public static Car findTopPositionCar(List<Car> cars) {
        Car winner = cars.get(0);
        if (cars.size() == 1) {
            return winner;
        }
        for(int i = 1; i < cars.size(); i++) {
            if (!winner.comparePosition(cars.get(i))) {
                winner = cars.get(i);
            }
        }
        return winner;
    }

    public static void showWinner(){
        Car topPositionCar = findTopPositionCar(cars);
        for (Car car : cars){
            topPositionCar.findWinners(car);
        }
        OutputView.printWinners(Car.winners.toString());
    }

}
