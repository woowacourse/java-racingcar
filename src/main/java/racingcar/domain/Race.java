package racingcar.domain;

import java.util.List;
import java.util.Random;

public class Race {
    public static final int VALUE_LIMIT = 10;
    public static final int MOVING_CRITERIA = 4;
    private Random random = new Random();

    public void startRace(Cars cars) {
        moveCars(cars.getCars());
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = getRandomNumber();

            moveAccordingToCondition(car, randomValue);
        }
    }

    void moveAccordingToCondition(Car car, int condition) {
        if (condition >= MOVING_CRITERIA) {
            car.moveForward();
        }
    }

    private int getRandomNumber() {
        return random.nextInt(VALUE_LIMIT);
    }
}