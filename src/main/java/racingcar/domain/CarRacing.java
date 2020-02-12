package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {
    private List<Car> cars;

    public CarRacing(List<String> names) {
        this.cars = names.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }
}
