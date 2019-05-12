/*
 * @(#)Racing.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package model;

import java.util.Random;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class Racing {
    /*자동차 경주(각 시도) 진행을 담당하는 클래스*/
    private static final int RANDOM_BOUND = 10;
    private Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public Cars run() {
        for (Car car : cars.getCars()) {
            Random random = new Random();
            car.move(random.nextInt(RANDOM_BOUND));
        }

        return cars;
    }
}
