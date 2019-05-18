package racingcargame.model;

import java.util.*;


public class CarsGenerator {
    public static List<Car> makeCars(String carNames) {
        carNames = carNames.replaceAll(" ","");
        List<String> names = CarNames.makeCarNames(carNames);
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

}
