package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public void startEachRace() {
        for (Car car : cars) {
            checkAndMove(car);
        }
    }

    private void checkAndMove(Car car) {
        if (makeRandom() >= 4) {
            car.moveForward();
        }
    }

    private int makeRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getSize() {
        return cars.size();
    }

    public List<String> getCarsToString() {
        List<String> carsToString = new ArrayList<>();
        for (Car car : this.cars) {
            carsToString.add(car.toString());
        }
        return carsToString;
    }
}
