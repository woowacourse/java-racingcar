package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

/*    public Cars(Car car) {
        cars.add(car);
    }*/

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public int createRandomValue() {
        return (int) (Math.random() * 10);
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