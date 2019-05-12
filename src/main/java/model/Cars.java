/*
 * @(#)Cars.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class Cars implements Cloneable {
    /*경주를 진행하는 자동차들에 대한 클래스*/
    private static final String REGEX_CAR_NAMES_FORMAT = "^([^,]+)(,[^,]+)*$";
    private static final String REGEX_CAR_NAMES_SPLIT = ",";
    private List<Car> cars = new ArrayList<>();

    public Cars(String inputCarNames) {
        checkCarNamesFormat(inputCarNames);
        parseCars(inputCarNames);
    }

    public Cars(Cars cars) throws CloneNotSupportedException {
        for (Car car : cars.getCars()) {
            this.cars.add(car.copy());
        }
    }

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static void checkCarNamesFormat(String inputCarNames) {
        if (!inputCarNames.matches(REGEX_CAR_NAMES_FORMAT)) {
            throw new IllegalArgumentException("자동차 이름 입력형식에 맞지 않습니다.");
        }
    }

    private void parseCars(String inputCarNames) {
        for (String carName : inputCarNames.split(REGEX_CAR_NAMES_SPLIT)) {
            Car car = new Car(new CarName(carName));
            checkCarNamesDuplication(cars, car);
            this.cars.add(car);
        }
    }

    private void checkCarNamesDuplication(List<Car> cars, Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
        }
    }

    List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString());
        }
        return sb.append("\n").toString();
    }
}