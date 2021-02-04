package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.view.ErrorMessages;

public class CarRepository {
    private static List<Car> cars = new ArrayList<>();

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static void addCar(Car car) {
        cars.add(car);
    }

    public static void addCars(List<Car> copyingCars) {
        cars.addAll(copyingCars);
    }

    public static int selectMaxPosition(){
        return cars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public static int getSize() {
        return cars.size();
    }
}
