package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int round;

    private final int INIT_ROUND = 1;

    public RacingGame() {
        this.round = INIT_ROUND;
    }

    public void makeCars(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }

    public void playRound() {
        cars.forEach(car -> car.move(RandomGenerator.generateRandomNumber()));
        round++;
    }

    public List<Car> getCars() {
        return cars;
    }
}
