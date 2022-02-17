package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.RandomGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(RandomGenerator.generateRandomNumber());
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
        cars.stream()
            .filter(car -> car.isSamePosition(highScore))
            .forEach(car -> champions.add(car.getName()));
        return champions;
    }

    public List<Car> getCars() {
        return cars;
    }
}
