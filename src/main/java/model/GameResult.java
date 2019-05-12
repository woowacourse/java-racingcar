/*
 * @(#)GameResult.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package model;

import java.util.Collections;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class GameResult {
    /*게임결과(우승자)와 게임결과(우승자)추출을 담당하는 클래스*/
    private Winners winners;

    public GameResult() {
        winners = new Winners();
    }

    public Winners findWinner(Cars cars) {
        Car maxPositionCar = Collections.max(cars.getCars());

        for (Car car : cars.getCars()) {
            addWinners(maxPositionCar, car);
        }

        return winners;
    }

    private void addWinners(Car maxPositionCar, Car car) {
        if (car.compareTo(maxPositionCar) == 0) {
            winners.addWinners(car.getName());
        }
    }
}
