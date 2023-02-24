package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final int RANDOM_NUM_MAX_VALUE = 10;
    private static final String DELIMITER = ",";
    private static final Random random = new Random();

    private final List<Car> cars;

    public Cars(String carNames) {
        this(Stream.of(carNames.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
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
        return this.cars.stream()
                .mapToInt(car -> car.getDistance().getValue())
                .max()
                .orElse(-1);
    }

    private void compareDistance(List<String> winner, Car car, int maxDistance) {
        if (car.getDistance().getValue() == maxDistance) {
            winner.add(car.getName().getValue());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
