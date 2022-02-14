package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int INITIAL_POSITION = 0;

    private final List<Car> cars;
    private final List<String> champions;
    private int highScore;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        this.champions = new ArrayList<>();
        this.highScore = 0;
        for (String name : names) {
            cars.add(new Car(name, INITIAL_POSITION));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(car.startEngine());
        }
    }

    public List<String> getChampions() {
        updateHighScore();
        verifyChampion();
        return champions;
    }

    private void updateHighScore() {
        for (Car car : cars) {
            highScore = Math.max(highScore, car.getPosition());
        }
    }

    private void verifyChampion() {
        for (Car car : cars) {
            verifyMaxPosition(car);
        }
    }

    private void verifyMaxPosition(Car car) {
        if (car.isSamePosition(highScore)) {
            champions.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
