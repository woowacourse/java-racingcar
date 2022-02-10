package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private List<Car> cars = new ArrayList<>();

    public void insertCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public int carCount() {
        return cars.size();
    }
}
