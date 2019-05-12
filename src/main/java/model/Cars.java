package model;

import java.util.ArrayList;
import java.util.List;

public class Cars implements Cloneable {
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

    private static void checkCarNamesFormat(String inputCarNames) {
        if (!inputCarNames.matches(REGEX_CAR_NAMES_FORMAT)) {
            throw new IllegalArgumentException("자동차 이름 형식에 맞지 않습니다.");
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