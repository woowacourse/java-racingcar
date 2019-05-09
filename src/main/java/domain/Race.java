package domain;

import utils.RandomUtil;

import java.util.ArrayList;

public class Race {

    public static void raceByRound(ArrayList<Car> carList) {
        for (Car car : carList) {
            car.move(RandomUtil.randomNumber());
        }
    }
}