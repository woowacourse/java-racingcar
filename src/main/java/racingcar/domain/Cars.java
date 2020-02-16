package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(CarNames carNames) {
        this.cars = setCars(carNames);
    }

    private List<Car> setCars(CarNames carNameFactory) {
        List<Car> returnCars = new ArrayList<>();
        List<CarName> carNames = carNameFactory.getCarNames();
        for (CarName carName : carNames) {
            returnCars.add(new Car(carName));
        }
        return returnCars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions.stream()
            .max(Integer::compare)
            .orElse(-1);
    }
}
