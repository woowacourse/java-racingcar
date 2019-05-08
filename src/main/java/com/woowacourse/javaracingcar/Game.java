package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int STOP_BOUND = 3;
    private static final int MOVE_BOUND = 4;
    private List<Car> cars;
    private NumberGenerator numberGenerator;
    private int tries;

    public Game(NumberGenerator generator, int tries, List<Car> cars) {
        numberGenerator = generator;
        this.tries = tries;
        this.cars = cars;
    }

    public List<Car> loop() {
        // 게임 루프
        for (int i = 0; i < tries; i++) {
            for (Car c : cars)  {
                c.moveForward(calculateMovingPosition(numberGenerator.generateNumber()));
            }
        }

        // 우승자 선정
        int max = calculateMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car c : cars) {
            if (c.getPosition() == max) {
                winners.add(c);
            }
        }

        return winners;
    }

    public int calculateMovingPosition(int generatedNumber) {
        if (generatedNumber >= MOVE_BOUND) {
            return 1;
        }
        if (generatedNumber <= STOP_BOUND) {
            return 0;
        }
        throw new IllegalArgumentException("올바르지 않은 인수: " + generatedNumber);
    }

    public int calculateMaxPosition() {
        int max = 0;

        for (Car c : cars) {
            if (c.getPosition() > max) {
                max = c.getPosition();
            }
        }

        return max;
    }
}
