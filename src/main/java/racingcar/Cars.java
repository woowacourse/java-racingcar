package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final Set<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = new HashSet<>(carList);
    }

    public int getNumberOfCar() {
        return cars.size();
    }
}
