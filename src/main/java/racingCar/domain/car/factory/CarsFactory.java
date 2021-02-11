package racingCar.domain.car.factory;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingCar.domain.car.Car;
import racingCar.domain.car.Cars;
import racingCar.domain.car.Engine.Engine;

public class CarsFactory {

    public static Cars create(String[] names, Engine engine) {
        return new Cars(Arrays.stream(names)
            .map(name -> new Car(name, engine))
            .collect(Collectors.toList()));
    }
}
