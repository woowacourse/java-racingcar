package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<Car> cars;
    private int gameRound;

    public GameResult(List<String> names, int gameRound) {
        cars = new ArrayList<>();
        this.gameRound = gameRound;

        registerCars(names);
    }

    private void registerCars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    Car decideMaxPositionCar() {
        Car maxPositionCar = cars.get(0);

        for (Car car : cars) {
            if (maxPositionCar.compareTo(car) < 0) {
                maxPositionCar = car;
            }
        }

        return maxPositionCar;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getGameRound() {
        return gameRound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return gameRound == that.gameRound &&
                Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, gameRound);
    }
}
