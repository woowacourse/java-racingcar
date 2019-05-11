package model;

import java.util.ArrayList;
import java.util.List;

public class Cars implements Cloneable {
    private static final String REGEX_CAR_NAMES_FORMAT = "^([A-Za-z]+)(,[A-Za-z]+)*$";
    private static final String REGEX_CAR_NAMES_SPLIT = ",";
    private List<Car> cars;

    public Cars(String carNames) {
        checkCarNamesFormat(carNames);
        this.cars = parseCars(carNames);
    }

    private static void checkCarNamesFormat(String carNames) {
        if (!carNames.matches(REGEX_CAR_NAMES_FORMAT)) {
            throw new IllegalArgumentException("자동차 이름 형식에 맞지 않습니다.");
        }
    }

    private List<Car> parseCars(String carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames.split(REGEX_CAR_NAMES_SPLIT)) {
            Car car = new Car(new CarName(carName));
            checkCarNamesDuplication(cars, car);
            cars.add(car);
        }
        return cars;
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

    public Cars copy() {
        try {
            Cars copyCars = (Cars) clone();
            copyCars.cars = deepCopy(cars);
            return copyCars;
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("자동차들 복제를 실패했습니다.");
        }
    }

    private List<Car> deepCopy(List<Car> source) {
        List<Car> copy = new ArrayList<>();
        for (Car car : source) {
            copy.add(car.copy());
        }
        return copy;
    }
}