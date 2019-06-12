package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestCars {
    public static Cars generateCars(int numCars, Distance distance) {
        return Cars.from(IntStream.range(0, numCars)
                .mapToObj(Integer::toString)
                .map(CarName::from)
                .map(name -> Car.of(name, distance))
                .collect(Collectors.toList()));
    }

    public static Cars of(List<String> names, List<Integer> distances) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            CarName name = CarName.from(names.get(i));
            Distance distance = Distance.from(distances.get(i));

            cars.add(Car.of(name, distance));
        }
        return Cars.from(cars);
    }
}
