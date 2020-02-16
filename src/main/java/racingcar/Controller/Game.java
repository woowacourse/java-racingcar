package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.Model.Car;
import racingcar.Model.RandomNumber;
import racingcar.Model.GameResult;

/**
 * 클래스 이름 : Game.java
 *
 * @author 작은곰
 * @version 1.0.2
 * <p>
 * 날짜 : 2020.02.17 월요일
 */

public class Game {
    private static List<Car> gamecars = new ArrayList<>();

    public static void initialize(List<Car> cars) {
        gamecars = cars;
    }

    public static GameResult race() {
        for (Car car : gamecars) {
            RandomNumber randomNumber = new RandomNumber();
            car.goOrNot(randomNumber);
        }
        return new GameResult(gamecars);
    }

    public static String showWinner() {
        int topPosition = findTopPositionCar(gamecars);
        for (Car car : gamecars) {
            car.findWinners(topPosition);
        }
        return Car.winners.toString();
    }

    public static int findTopPositionCar(List<Car> cars) {
        List<Integer> carPosition = new ArrayList<>();
        for (Car car : cars) {
            carPosition.add(car.getPosition());
        }
        int topPosition = carPosition.stream().max(Integer::compare).orElse(-1);
        return topPosition;
    }
}
