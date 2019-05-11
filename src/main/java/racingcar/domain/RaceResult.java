package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceResult {
    private List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinningCars() {
        List<Car> winningCars = new ArrayList<>();
        winningCars.add(cars.get(0));

        for (int i = 1; i < cars.size(); i++) {
            addWinningCars(winningCars, cars.get(i));
        }
        return winningCars;
    }

    private void addWinningCars(List<Car> winningCars, Car nextCar) {
        int result = nextCar.comparePosition(winningCars.get(0));

        if (result == 1) {
            return;
        }
        if (result == -1) {
            winningCars.clear();
        }
        winningCars.add(nextCar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceResult that = (RaceResult) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
