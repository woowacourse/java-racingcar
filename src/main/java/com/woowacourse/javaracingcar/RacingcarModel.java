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

    public Game(NumberGenerator generator, List<Car> cars) {
        numberGenerator = generator;
        this.cars = cars;
    }

    /**
     * 각 자동차에 대해 난수를 생성하고 이에 따라 전진(혹은 멈춤)하는 과정을 1회 수행
     * @return 게임에 참여한 자동차 리스트
     */
    public List<Car> loop() {
        for (Car c : cars)  {
            c.move(calculateMovingPosition(numberGenerator.generateNumber()));
        }

        return new ArrayList<>(cars);
    }

    public List<Car> getWinners() {
        int max = calculateMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car c : cars) {
            if (c.getPosition() == max) {
                winners.add(c);
            }
        }

        return winners;
    }

    private int calculateMovingPosition(int generatedNumber) {
        if (generatedNumber >= MOVE_BOUND) {
            return 1;
        }
        if (generatedNumber <= STOP_BOUND) {
            return 0;
        }
        throw new IllegalArgumentException("올바르지 않은 인수: " + generatedNumber);
    }

    private int calculateMaxPosition() {
        int max = 0;

        for (Car c : cars) {
            if (c.getPosition() > max) {
                max = c.getPosition();
            }
        }

        return max;
    }
}
