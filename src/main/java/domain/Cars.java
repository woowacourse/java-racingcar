package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carInformation = new ArrayList<>();
    PowerNumberGenerator powerNumberGenerator = new PowerRandomNumberGenerator();


    public void creatCar(String[] inputCarsName) {
        for (String carName : inputCarsName) {
            carInformation.add(new Car(carName));
        }
    }

    public List<Car> powerInjectionAllCars() {
        for (Car car : carInformation) {
            car.move(powerNumberGenerator.generate());
        }
        return carInformation;
    }

    public List<String> selectWinners() {
        return carInformation.stream()
                .filter(car -> Collections.max(positions()) == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Integer> positions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : carInformation) {
            positions.add(car.getPosition());
        }
        return positions;
    }

}
