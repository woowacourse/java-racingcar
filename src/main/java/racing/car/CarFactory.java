package racing.car;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> makeCars(List<String> names) {
        return names.stream()
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
