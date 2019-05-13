package com.woowacourse.javaracingcar.domain;

import com.woowacourse.javaracingcar.interfaces.RacingcarGameRule;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {
    private final PlayingCars cars;
    private final RacingcarGameRule rule;

    public RacingcarGame(final List<Car> cars, final RacingcarGameRule rule) {
        if (cars == null || rule == null) {
            throw new IllegalArgumentException("One or more argument(s) is null");
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("Car list is empty");
        }

        this.cars = new PlayingCars(cars);
        this.rule = rule;
    }

    /**
     * 각 자동차에 대해 난수를 생성하고 이에 따라 전진(혹은 멈춤)하는 과정을 1회 수행
     *
     * @return 게임에 참여한 자동차 리스트
     */
    public GameResult loop(int tries) {
        List<GameRound> rounds = new ArrayList<>();

        for (int i = 0; i < tries; i++) {
            cars.retrieveAllCars().forEach(c -> {
                cars.moveCar(c.getName(), rule.getPositionToMove());
            });
            rounds.add(new GameRound(cars));
        }

        return new GameResult(rounds);
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
