package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinningCars {
    private List<String> winningCarNames = new ArrayList<>();

    public WinningCars(Set<Car> cars) {
        Car maxCar = this.getMaxCar(cars);
        for (Car car : cars) {
            this.addWinners(maxCar, car);
        }
    }

    private Car getMaxCar(Set<Car> cars) {
        Car maxCar = new Car("tmp");
        for (Car car : cars) {
            maxCar = (maxCar.compareTo(car) < 0) ? car : maxCar;
        }
        return maxCar;
    }

    private void addWinners(Car maxCar, Car car) {
        if (maxCar.compareTo(car) == 0) {
            winningCarNames = car.addCarInWinners(this.winningCarNames);
        }
    }

    /* Test를 위한 Code */
    public boolean isWinner(String name) {
        return winningCarNames.contains(name);
    }

    @Override
    public String toString() {
        return String.join(", ", winningCarNames) + " 가 최종 우승했습니다.";
    }
}
