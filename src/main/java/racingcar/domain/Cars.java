package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = setCars(carNames);
    }

    private List<Car> setCars(List<String> carNames) {
        List<Car> returnCars = new ArrayList<>();
        for (String carName : carNames) {
            returnCars.add(new Car(carName));
        }
        return returnCars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
