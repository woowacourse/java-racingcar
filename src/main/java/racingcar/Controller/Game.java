package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.Model.Car;
import racingcar.View.OutputView;

/**
 * 클래스 이름 : Game.java
 *
 * @author 작은곰
 * @version 1.0.1
 * <p>
 * 날짜 : 2020.02.16 일요일
 */

public class Game {
    private static final int INDEX_START = 0;

    private static List<Car> gamecars = new ArrayList<>();
    private static int trialTime;

    public static void initialize(List<Car> cars, int tryNo) {
        gamecars = cars;
        trialTime = tryNo;

    }

    public static void race() {
        OutputView.printResultMessage();
        for (int index = INDEX_START; index < trialTime; index++) {
            raceOneRound();
            OutputView.printNewLine();
        }
    }

    private static void raceOneRound() {
        for (Car car : gamecars) {
            car.goOrNot();
            OutputView.printPositionByDash(car);
        }
    }

    public static void showWinner() {
        Car topPositionCar = findTopPositionCar(gamecars);
        for (Car car : gamecars) {
            topPositionCar.findWinners(car);
        }
        OutputView.printWinners(Car.winners.toString());
    }

    public static Car findTopPositionCar(List<Car> cars) {
        Car winner = cars.get(0);
        int carSize = cars.size();

        if (carSize == 1) {
            return winner;
        }

        for (int i = 1; i < carSize; i++) {
            winner = findWinner(cars, winner, i);
        }

        return winner;
    }

    private static Car findWinner(List<Car> cars, Car winner, int i) {
        if (!winner.comparePosition(cars.get(i))) {
            winner = cars.get(i);
        }
        return winner;
    }

}
