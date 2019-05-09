package com.woowacourse.javaracingcar.domain;

import com.woowacourse.javaracingcar.RacingCarUtil;
import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingcarModel {
    private static final int STOP_BOUND = 3;
    private static final int MOVE_BOUND = 4;
    private List<Car> cars;
    private NumberGenerator numberGenerator;

    public RacingcarModel(NumberGenerator generator, List<String> carNames) {
        numberGenerator = generator;
        this.cars = RacingCarUtil.createCars(carNames);
    }

    /**
     * 각 자동차에 대해 난수를 생성하고 이에 따라 전진(혹은 멈춤)하는 과정을 1회 수행
     *
     * @return 게임에 참여한 자동차 리스트
     */
    public List<CarDto> loop() {
        for (Car c : cars) {
            c.move(calculateMovingPosition(numberGenerator.generateNumber()));
        }

        return convertToDtoList();
    }

    public List<CarDto> getWinners() {
        int max = calculateMaxPosition();
        List<CarDto> winners = new ArrayList<>();
        for (Car c : cars) {
            if (c.getPosition() == max) {
                winners.add(new CarDto(c.getName(), c.getPosition()));
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
        if (cars.isEmpty()) {
            throw new IllegalStateException("Car list is empty");
        }
        return Collections.max(cars).getPosition();
    }

    private List<CarDto> convertToDtoList() {
        return cars.stream()
            .map(c -> new CarDto(c.getName(), c.getPosition()))
            .collect(Collectors.toList());
    }
}
