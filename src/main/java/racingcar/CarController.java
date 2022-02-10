package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarController {

    private List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();

        Car maxPositionCar = getMaxPositionCar();
        for (Car car : cars) {
            if (car.isSamePositionWith(maxPositionCar)) {
                winners.add(car);
            }
        }


        return winners;
    }

    private Car getMaxPositionCar() {
        cars.sort(Comparator.reverseOrder());
        return cars.get(0);
    }
}
