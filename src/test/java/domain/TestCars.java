package domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestCars {
    public static Cars generateCars(int numCars, Distance distance) {
        return Cars.from(IntStream.range(0, numCars)
                .mapToObj(Integer::toString)
                .map(name -> Car.of(name, distance))
                .collect(Collectors.toList()));
    }
}
