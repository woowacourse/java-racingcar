package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int INITIAL_POSITION = 0;

    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, INITIAL_POSITION));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getChampions() {
        return findChampions(getHighScore());
    }

    private int getHighScore() {
        int highScore = 0;
        for (Car car : cars) {
            highScore = Math.max(highScore, car.getPosition());
        }
        return highScore;
    }

    private List<String> findChampions(int highScore) {
        List<String> champions = new ArrayList<>();
        for (Car car : cars) {
            addIfChampion(champions, car, highScore);
        }
        return champions;
    }

    private void addIfChampion(List<String> champions, Car car, int highScore) {
        if (car.isSamePosition(highScore)) {
            champions.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
