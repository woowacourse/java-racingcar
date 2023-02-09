package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static void addCars(Car car) {
        cars.add(car);
    }

    public static void moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public static List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static int getMaxPosition() {
        List<Integer> position = new ArrayList<>();
        for (Car car : cars) {
            position.add(car.getPosition());
        }
        return Collections.max(position);
    }


}
