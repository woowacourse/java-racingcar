package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void startEachRace() {
        for (Car car : cars) {
            car.move(makeRandom());
        }
    }

    private int makeRandom() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winnerCars = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .forEach(winnerCars::add);
        return winnerCars;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public int getSize() {
        return cars.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
