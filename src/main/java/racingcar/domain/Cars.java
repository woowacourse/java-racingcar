package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int RANDOM_NUMBER_MAX = 10;

    private List<Car> cars;
    private MoveController movingNumber = () -> (int) (Math.random() * RANDOM_NUMBER_MAX);

    public Cars(Names names) {
        this.cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition(movingNumber);
        }
    }

    public String getCurrentResult() {
        StringBuilder currentResult = new StringBuilder();
        for (Car car : cars) {
            currentResult.append(car.getCurrentPosition());
            currentResult.append("\n");
        }
        return currentResult.toString();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}