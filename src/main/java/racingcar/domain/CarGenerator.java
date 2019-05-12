package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarGenerator {

    public CarGenerator() {
    }

    public List<Car> generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for(String carName : carNames){
            cars.add(new Car(carName));
        }

        return cars;
    }
}
