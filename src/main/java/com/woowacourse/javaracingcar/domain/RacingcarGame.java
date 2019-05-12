package com.woowacourse.javaracingcar.domain;

import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcar.interfaces.RacingcarGameRule;

import java.util.List;

public class RacingcarGame {
    private final PlayingCars cars;
    private final NumberGenerator numberGenerator;
    private final RacingcarGameRule rule;

    public RacingcarGame(final NumberGenerator generator, final List<Car> cars, final RacingcarGameRule rule) {
        if (generator == null || cars == null || rule == null) {
            throw new IllegalArgumentException("One or more argument(s) is null");
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("Car list is empty");
        }

        this.numberGenerator = generator;
        this.cars = new PlayingCars(cars);
        this.rule = rule;
    }

    /**
     * 각 자동차에 대해 난수를 생성하고 이에 따라 전진(혹은 멈춤)하는 과정을 1회 수행
     *
     * @return 게임에 참여한 자동차 리스트
     */
    public PlayingCars loop() {
        for (CarDto c : cars.retrieveAllCars()) {
            cars.update(new CarDto(c.getName(), c.getPosition() + calculateMovingPosition(numberGenerator.generateNumber())));
        }

        return cars;
    }

    private int calculateMovingPosition(final int generatedNumber) {
        return rule.calculatePositionToMove(generatedNumber);
    }

    public WinnerGroup getWinners() {
        return new WinnerGroup(cars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        cars.retrieveAllCars().forEach(sb::append);
        sb.append("]");
        return String.format("RacingcarGame { cars: %s }", sb.toString());
    }
}
