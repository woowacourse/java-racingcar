package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(final List<String> carNames) {
        cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void progressRace() {
        for (Car c : cars) {
            c.tryGoForward(RandomNumberGenerator.generate(Car.RANDOM_NUM_UPPER_BOUND));
        }
    }

    public List<Car> getWinners() {
        return findWinners(cars);
    }

    public static List<Car> findWinners(final List<Car> cars) {
        List<Car> winners = new ArrayList<>(cars);
        Car winner = findWinner(cars);
        winners.removeIf((c) -> (!isSamePosition(c, winner)));
        return winners;
    }

    private static Car findWinner(final List<Car> cars) {
        return Collections.max(cars);
    }

    private static boolean isSamePosition(final Car c1, final Car c2) {
        return c1.compareTo(c2) == 0;
    }
}
