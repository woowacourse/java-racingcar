package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<CarName> carNames) {
        this.cars = setCars(carNames);
    }

    private List<Car> setCars(List<CarName> carNames) {
        List<Car> returnCars = new ArrayList<>();
        for (CarName carName : carNames) {
            returnCars.add(new Car(carName));
        }
        return returnCars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
