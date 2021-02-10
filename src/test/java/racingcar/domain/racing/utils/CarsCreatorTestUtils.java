package racingcar.domain.racing.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarsCreatorTestUtils {
    public static List<String> createCarNamesSizeOf(int carSize) {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < carSize; i++) {
            carNames.add(String.valueOf(i));
        }
        return carNames;
    }

    public static List<Car> createCarsSizeOf(int carSize) {
        List<String> carNames = createCarNamesSizeOf(carSize);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
