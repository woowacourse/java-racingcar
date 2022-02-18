package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
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
        List<String> champions = new ArrayList<>();
        cars.stream()
            .filter(car -> car.isSamePosition(highScore))
            .forEach(car -> champions.add(car.getName()));
        return champions;
    }

    private int getHighScore() {
        return cars.stream().mapToInt(Car::getPosition).max().orElseThrow();
    }

    public List<Car> getCars() {
        return cars;
    }
}
