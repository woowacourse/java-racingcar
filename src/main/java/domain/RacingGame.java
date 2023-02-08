package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(String[] names) {
        this.cars = new ArrayList<>();

        //TODO: 메소드 분리
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }
}
