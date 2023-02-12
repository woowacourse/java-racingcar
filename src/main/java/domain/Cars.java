package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carInformation = new ArrayList<>();
    PowerNumberGenerator powerNumberGenerator = new PowerRandomNumberGenerator();


    public void creatCar(String[] inputCarsName) {
        for (String carName : inputCarsName) {
            carInformation.add(new Car(carName));
        }
    }
}
