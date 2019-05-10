package com.woowacourse.javaracingcarwithoutif.domain;

import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcarwithoutif.RacingcarUtil;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RacingcarModel {
    private static final int MOVE_BOUND = 4;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public RacingcarModel(final NumberGenerator generator, final List<String> carNames) {
        numberGenerator = generator;
        this.cars = RacingcarUtil.createCars(carNames);
    }

    public List<CarDto> loop() {
        for (Car c : cars) {
            c.move(calculateMovingPosition(numberGenerator.generateNumber()));
        }

        return convertToDtoList();
    }

    public List<CarDto> getWinners() {
        final int max = calculateMaxPosition();

        return cars.stream()
            .filter(c -> c.getPosition() == max)
            .map(c -> new CarDto(c.getName(), c.getPosition()))
            .collect(Collectors.toList());
    }

    // ref. https://stackoverflow.com/a/52348419/5720753
    private int calculateMovingPosition(final int generatedNumber) {
        // 정말 이렇게 하는게 맞는걸까...?
        final Optional<Integer> optResult = Optional.of(generatedNumber);
        final Predicate<Integer> conditionToForward = i -> i >= MOVE_BOUND;
        final Supplier<Integer> positionToMoveSupplier = () -> optResult
            .filter(conditionToForward)
            .map(i -> 1)
            .orElse(0);
        return positionToMoveSupplier.get();
    }

    private int calculateMaxPosition() {
        try {
            return Collections.max(cars).getPosition();
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Car list is empty");
        }
    }

    private List<CarDto> convertToDtoList() {
        return cars.stream()
            .map(c -> new CarDto(c.getName(), c.getPosition()))
            .collect(Collectors.toList());
    }
}
