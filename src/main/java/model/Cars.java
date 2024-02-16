package model;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(List<Boolean> moves) {
        for (int i = 0; i < moves.size(); i++) {
            cars.get(i).move(moves.get(i));
        }
    }

    public List<Car> findWinners() {
        int maxMovement = cars.stream().mapToInt(Car::getMovement).max().getAsInt();
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .toList();
    }

    public List<Car> getPresentCarsStatus() {
        return Collections.unmodifiableList(cars);
    }

    public int getCarsSize() {
        return cars.size();
    }
}
