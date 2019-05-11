package domain;

import utils.RandomUtil;

import java.util.List;

public class Race {
    public static void raceByRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomUtil.randomNumber());
        }
    }
}