package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<Car> cars;

    GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        List<Car> winnerCars = new ArrayList<>();
        Car maxPositionCar = decideMaxPositionCar();

        for (Car car : cars) {
            if (maxPositionCar.isEqualPosition(car)) {
                winnerCars.add(car);
            }
        }

        return Collections.unmodifiableList(winnerCars);
    }

    private Car decideMaxPositionCar() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
