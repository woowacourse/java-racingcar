package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private static final String NOTHING_NAME_ERROR_MASSAGE = "자동차 이름들이 존재하지 않음";
    private List<Car> cars = new ArrayList<>();
    private List<String> championNames = new ArrayList<>();

    public RacingGame(List<String> names) {
        validateNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(NOTHING_NAME_ERROR_MASSAGE);
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(car.generateRandomNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getChampionNames() {
        championNames.clear();
        Car firstCar = Collections.max(cars);

        for (Car car : cars) {
            addChampionName(firstCar, car);
        }

        return championNames;
    }

    private void addChampionName(Car firstCar, Car car) {
        if (car.isTiebreaker(firstCar)) {
            championNames.add(car.getName());
        }
    }
}
