package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int INITIAL_POSITION = 0;

    private final List<Car> cars;
    private final List<String> championList;
    private int highScore;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        this.championList = new ArrayList<>();
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

    public List<String> getChampionList() {
        updateHighScore();
        verifyChampion();
        return championList;
    }

    private void updateHighScore() {
        for (Car car : cars) {
            highScore = car.updateMaxPosition(highScore);
        }
    }

    private void verifyChampion() {
        for (Car car : cars) {
            verifyMaxPosition(car);
        }
    }

    private void verifyMaxPosition(Car car) {
        if (car.isMaxPosition(highScore)) {
            championList.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
