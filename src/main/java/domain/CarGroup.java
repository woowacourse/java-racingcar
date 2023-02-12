package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGroup {

    private static final String DUPLICATED_CAR_NAME_ERROR = "[ERROR] 자동차 이름에는 중복이 허용되지 않습니다.";
    private static final String RANGE_OF_CAR_GROUP_ERROR = "[ERROR] 자동차 대수는 2-50대 사이입니다.";
    private static final int MINIMUM_NUMBER_OF_CARS = 2;
    private static final int MAXIMUM_NUMBER_OF_CARS = 50;

    private final List<Car> cars;

    public CarGroup(List<String> names) {
        this.cars = new ArrayList<>();
        validateDuplicatedName(names);
        validateNumberOfCars(names);
        setUp(names);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generate());
        }
    }

    private void setUp(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void validateDuplicatedName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR);
        }
    }

    private void validateNumberOfCars(List<String> names) {
        if (names.size() < MINIMUM_NUMBER_OF_CARS || names.size() > MAXIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(RANGE_OF_CAR_GROUP_ERROR);
        }
    }
}
