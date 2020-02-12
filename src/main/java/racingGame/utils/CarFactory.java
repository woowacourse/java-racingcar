package racingGame.utils;

import racingGame.domain.Car;
import racingGame.domain.Name;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> createByNames(String carName) {
        List<Car> cars = new ArrayList<>();

        String[] carNames = carName.split(",");

        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(new Name(carNames[i])));
        }
        return cars;
    }
}
