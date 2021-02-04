package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static final List<Car> cars = new ArrayList<>();

    private CarRepository(){
    }

    public static void addCars(List<String> splittedCarNames){
        CarNameRepository.addCarNames(splittedCarNames);
        CarNameRepository.getCarNames().stream().map(carName -> cars.add(new Car(carName)));
    }

}
