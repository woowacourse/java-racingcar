package racingGame.utils;

import racingGame.domain.Car;
import racingGame.domain.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CarFactory {
    public static List<Car> createByNames(String carName) {
        List<Car> cars = new ArrayList<>();

        String[] carNames = carName.split(",");

        IntStream.range(0, carNames.length)
                .forEach(i -> cars.add(new Car(new Name(carNames[i]))));

        return cars;
    }
}
