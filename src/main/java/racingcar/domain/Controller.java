/*
 * Copyright (c) 2019 by 이름
 * All rights reserved.
 *
 * 클래스명.java
 * 클래스 설명
 *
 * @author      이름
 * @version     1.0
 * @date        dd mm yyyy
 *
 */

package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    private final List<Car> cars;
    private final int tryCount;

    public Controller(List<String> carNames, int tryCount) {
        this.cars =  setCars(carNames);
        this.tryCount  = tryCount;
    }

    private List<Car> setCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public String run() {
        StringBuilder executionResult = new StringBuilder();
        for (int i = 0; i < tryCount; i++) {
            executionResult.append("\n");
            for (Car car : cars) {
                if (getRandomNumber()) {
                    car.forward();
                }
                executionResult.append(car.toString());
            }
        }
        return executionResult.toString();
    }

    private boolean getRandomNumber() {
        Random random = new Random();
        return BehaviorJudgment.isForward(random.nextInt(10));
    }

    public String getWinner() {
        return Winner.getWinner(cars);
    }
}
