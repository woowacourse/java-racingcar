package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int RANDOM_BOUND = 10;
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = initializeCars(carNames);
    }

    public List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void randomMove() {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND);
    }

    public TrialHistory makeTrialHistory() {
        return new TrialHistory(cars);
    }
}
