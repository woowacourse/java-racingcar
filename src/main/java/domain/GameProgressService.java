package domain;

import utils.RandomUtil;

import java.util.List;

public class GameProgressService {
    public static void raceByRound(GameResult gameResult) {
        List<Car> cars = gameResult.getCars();

        for (Car car : cars) {
            car.move(RandomUtil.randomNumber());
        }
    }
}
