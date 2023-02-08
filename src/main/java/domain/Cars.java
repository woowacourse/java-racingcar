package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import strategy.MovingStrategy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void cycleCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            movingStrategy.isAllowedToMove(car);
        }
    }

    public List<String> getStatuses() {
        List<String> status = new ArrayList<>();
        for (Car car : cars) {
            status.add(car.getStatus());
        }
        return status;
    }

    public Map<Car, Integer> getNamesAndPositions() {
        Map<Car, Integer> namesAndPositions = new HashMap<>();

        for (Car car : cars) {
            namesAndPositions.put(car, car.getPosition());
        }
        return namesAndPositions;
    }
}
