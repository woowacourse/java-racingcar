package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private List<Car> cars = new ArrayList<>();
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void insertCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, randomNumberGenerator));
        }
    }

    public int carCount() {
        return cars.size();
    }

    public void moveRound() {
        for (Car car : cars) {
            car.move();
        }
    }
}
