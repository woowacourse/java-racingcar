package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int START_POSITION = 0;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        carNames.forEach(name -> cars.add(new Car(name, START_POSITION)));
    }

    void moveCars() {
        for (Car car : cars) {
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(MIN_NUMBER, MAX_NUMBER + 1);
            car.move(randomNumberGenerator.pickRandomNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
