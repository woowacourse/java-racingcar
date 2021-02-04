package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    static List<Car> cars = new ArrayList<>();

    static void carAdd(Car car){
        cars.add(car);
    }
}
