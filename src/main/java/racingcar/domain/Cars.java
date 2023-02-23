package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final int RANDOM_NUM_MAX_VALUE = 10;
    private static final Random random = new Random();

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = convertToCar(carNames);
    }

    private List<Car> convertToCar(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> runRound() {
        for (Car car : this.cars) {
            int randomNumber = random.nextInt(RANDOM_NUM_MAX_VALUE);
            car.runForward(randomNumber);
        }
        return this.cars;
    }

    public List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int maxDistance = findMaxDistance();
        for (Car car : this.cars) {
            compareDistance(winner, car, maxDistance);
        }
        return winner;
    }

    private int findMaxDistance() {
        int maxDistance = -1;
        for (Car car : this.cars) {
            maxDistance = Math.max(car.getDistance().getDistance(), maxDistance);
        }
        return maxDistance;
    }

    private void compareDistance(List<String> winner, Car car, int maxDistance) {
        if (car.getDistance().getDistance() == maxDistance) {
            winner.add(car.getName().getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
