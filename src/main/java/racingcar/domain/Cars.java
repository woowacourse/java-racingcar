package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String[] names) {
        return new Cars(Arrays.stream(names).map(Car::new).collect(toList()));
    }

    public void moveAll(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<String> getChampions() {
        return findChampions(getHighScore());
    }

    private List<String> findChampions(int highScore) {
        return cars.stream().filter(car -> car.isSamePosition(highScore)).map(Car::getName).collect(toList());
    }

    private int getHighScore() {
        return cars.stream().mapToInt(Car::getPosition).max().orElseThrow();
    }

    public List<Car> getCars() {
        return cars;
    }
}
