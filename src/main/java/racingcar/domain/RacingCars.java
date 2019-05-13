package racingcar.domain;

import racingcar.domain.Rule.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {
    private List<Car> cars = new ArrayList<>();

    public RacingCars() {
    }

    public RacingCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public boolean isOver(int count) {
        return cars.size() > count;
    }

    public RacingCars race(Rule rule) {
        RacingCars nextRacingCars = new RacingCars();

        for (Car car : this.cars) {
            nextRacingCars.add(car.move(rule));
        }
        return nextRacingCars;
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
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
