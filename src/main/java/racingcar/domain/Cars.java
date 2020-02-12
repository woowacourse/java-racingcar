package racingcar.domain;

import racingcar.generator.RandomNumberGenerator;
import racingcar.message.Message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * Cars.java
 * cars 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class Cars implements Iterable<Car> {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    Cars(List<String> names, List<Integer> position) {
        for (int i = 0; i < names.size(); i++) {
            cars.add(new Car(names.get(i), position.get(i)));
        }
    }

    public Car findMaxPositionCar() {
        return cars.stream()
                .reduce(Car::getBiggerCar)
                .orElseThrow(() -> new NullPointerException(Message.EXCEPTION_CAR_IS_NULL.getMessageText()));
    }

    public List<Car> findWinner() {
        Car maxPositionCar = findMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    void run() {
        for (Car car : cars) {
            car.run(RandomNumberGenerator.getRandomNumber());
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
