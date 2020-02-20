package racingcar.domian;

import racingcar.domian.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String DELIMITER = ",";
    private static final String CAR_COUNT_STR = "자동차 5대 초과입니다!";
    private static final int CAR_LIMIT = 5;

    private final List<Car> cars;

    public Cars(String inputNames) {
        String[] names = splitInputNames(inputNames);
        validateCarCount(names.length);
        List<Car> cars = new ArrayList<>();
        createCars(names, cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private String[] splitInputNames(String inputNames) {
        return inputNames.split(DELIMITER);
    }

    private List<Car> createCars(String[] names, List<Car> cars) {
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCarCount(int carCount) {
        if (carCount > CAR_LIMIT) {
            throw new IllegalArgumentException(CAR_COUNT_STR);
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.isMovable(RandomNumberGenerator.generateRandom());
        }
    }
}
