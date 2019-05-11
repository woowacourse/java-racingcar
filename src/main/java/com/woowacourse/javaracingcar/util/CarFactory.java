package com.woowacourse.javaracingcar.util;

import com.woowacourse.javaracingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> getCarsWithNames(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
