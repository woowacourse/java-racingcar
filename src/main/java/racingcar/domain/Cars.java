package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(Names names) {
        this.cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition(new RandomNumber());
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
        return cars;
    }
}