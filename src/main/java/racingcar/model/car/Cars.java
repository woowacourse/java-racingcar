package racingcar.model.car;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final String LINE_BREAK = "\n";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> movable())
                .forEach(Car::moveForward);
    }

    private boolean movable() {
        Random ran = new Random();
        int x = ran.nextInt(10);

        return x >= 4;
    }

    public String getCarsPositionFormat() {
        StringBuilder carsPositionFormat = new StringBuilder();
        for (Car car : cars) {
            carsPositionFormat.append(car.getCurrentStateFormat())
                    .append(LINE_BREAK);
        }

        return carsPositionFormat.toString();
    }

    public Cars getWinnerCars() {
        Integer maxPosition = Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));

        return new Cars(cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList()));
    }
}
