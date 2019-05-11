package domain;

import utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private static List<Car> cars;
    private static int gameRound;

    public static void registerCarNameAndGameRound(List<String> names, int gameRound) {
        cars = new ArrayList<>();
        GameResult.gameRound = gameRound;

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public static void raceByRound() {
        for (Car car : cars) {
            car.move(RandomUtil.randomNumber());
        }
    }

    public static List<Car> getCars() {
        return cars;
    }

    public static int getGameRound() {
        return gameRound;
    }
}
