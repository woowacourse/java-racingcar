package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();

    public static void addCars(List<Car> copyingCars) {
        cars.addAll(copyingCars);
    }

    public static List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public static List<Car> selectWinners(int maxPosition) {
        List<Car> winnerCars = cars().stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winnerCars);
    }

    public static void deleteAll() {
        cars.clear();
    }
}
