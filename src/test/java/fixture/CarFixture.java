package fixture;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import model.Car;
import model.Cars;
import model.Name;

public class CarFixture {
    public static Car 자동차() {
        return 자동차("prin");
    }

    public static Car 자동차(String name) {
        return new Car(new Name(name));
    }

    public static Cars 자동차들() {
        return new Cars(List.of(자동차("prin"), 자동차("mark")));
    }

    public static Cars 자동차들(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> 자동차("car" + i))
                .collect(collectingAndThen(toList(), Cars::new));
    }
}
