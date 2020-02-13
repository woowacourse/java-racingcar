package racingcargame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String DELIMITER = ",";
    private static final String NO_CAR_ERROR_MESSAGE = "입력된 자동차가 없습니다.";
    private static final String ONE_CAR_ERROR_MESSAGE = "하나의 자동차만 입력되었습니다.";

    private final List<Car> cars = new ArrayList<>();

    RacingCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public void move() {
        cars.forEach(car -> car.go(Engine.createRandomEngine()));
    }

    public List<Car> extractWinners() {
        Collections.sort(cars);
        Car firstScoreCar = cars.get(cars.size() - 1);
        List<Car> winners = cars.stream()
                .filter(car -> car.isSameToPosition(firstScoreCar))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winners);
    }

    public List<Car> getUnmodifiableCars() {
        return Collections.unmodifiableList(cars);
    }

    public static RacingCars createRacingCars(String inputCarNames) {
        String[] splicedInputCarNames = inputCarNames.split(DELIMITER);
        validCarAmount(splicedInputCarNames);
        List<Car> cars = new ArrayList<>();
        for (String inputCarName : splicedInputCarNames) {
            cars.add(new Car(inputCarName));
        }
        return new RacingCars(cars);
    }

    private static void validCarAmount(String[] splicedInputCarNames) {
        if (splicedInputCarNames.length == 0) {
            System.out.println(NO_CAR_ERROR_MESSAGE);
            throw new RuntimeException();
        }
        if (splicedInputCarNames.length == 1) {
            System.out.println(ONE_CAR_ERROR_MESSAGE);
            throw new RuntimeException();
        }
    }
}
