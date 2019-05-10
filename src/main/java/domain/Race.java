package domain;

import utils.RandomUtil;

import java.util.ArrayList;

public class Race {
    public static void raceByRound(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.move(RandomUtil.randomNumber());
        }
    }
}