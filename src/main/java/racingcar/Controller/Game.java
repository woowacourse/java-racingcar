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
            int randomNumber = RandomNumber.randomNumberCreate();
            car.goOrNot(randomNumber);
        }
        return new GameResult(gamecars);
    }

    public static String showWinner() {
        StringBuilder winners = new StringBuilder();
        int topPosition = findTopPositionCar(gamecars);
        for (Car car : gamecars) {
            findWinners(winners, topPosition, car);
        }
        return winners.toString();
    }

    private static void findWinners(StringBuilder winners, int topPosition, Car car) {
        if(car.isWinner(topPosition)){
            winners.append(", ");
            winners.append(car.getName());
        }
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
