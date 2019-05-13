package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    public List<Car> generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

}
