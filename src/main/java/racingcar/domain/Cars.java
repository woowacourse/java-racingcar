package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int RANDOM_VALUE_LIMIT = 10;

    private List<Car> cars;

    public Cars(Names names) {
        List<Name> na = names.getNames();
        cars = na.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int createRandomValue() {
        return (int) (Math.random() * RANDOM_VALUE_LIMIT);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition(createRandomValue());
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