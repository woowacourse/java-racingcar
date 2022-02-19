package carracinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    List<Car> cars = new ArrayList<>();

    public void makeCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
