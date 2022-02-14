package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.view.ErrorMessage;

public class Cars {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final int NONE_DUPLICATION = 0;

    private List<Car> cars;

    public Cars(String[] names) {
        cars = new ArrayList<>();
        createCarsWith(names);
    }

    private void createCarsWith(String[] names) {
        for (String name : names) {
            addCar(name);
        }
    }

    private void addCar(String name) {
        CarName carName = new CarName(name);
        Car car = new Car(carName);
        validDuplicateCarName(car);
        cars.add(car);
    }

    public String repeatRaceBy(Attempt attempt) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RACE_RESULT_MESSAGE).append(System.lineSeparator());
        while (attempt.isLeft()) {
            stringBuilder.append(raceAll());
            attempt.decrease();
        }
        return stringBuilder.toString();
    }

    private String raceAll() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            car.move();
            stringBuilder.append(car.toString());
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public Winners judgeWinners() {
        Car maxPositionCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchElementException(ErrorMessage.CAR_NOT_FOUND.toString()));
        return new Winners(cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::getName)
                .collect(Collectors.toList()));
    }

    private void validDuplicateCarName(Car car) {
        if (cars.stream().filter(each -> each.isSameName(car)).count() != NONE_DUPLICATION) {
            throw new RuntimeException(ErrorMessage.CAR_NAME_DUPLICATE.toString());
        }
    }

    public boolean isSize(int size) {
        return cars.size() == size;
    }
}
