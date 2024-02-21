package domain;

import java.util.ArrayList;
import java.util.List;

public class RoundRecord {

    private final List<Car> cars = new ArrayList<>();

    public RoundRecord(List<Car> cars) {
        for (Car car : cars) {
            this.cars.add(new Car(car.getName(), car.getScore()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
