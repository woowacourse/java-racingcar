package racingcar.domain;

import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String[] names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(createCar(name.trim()));
        }
    }

    public void play() {
        for (Car car : cars) {
            car.drive();
        }
        Output.roundResult(cars);
    }

    private Car createCar(String name) {
        return new Car(name);
    }
}
