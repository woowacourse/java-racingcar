package racingcar.domain;

import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> names) {
        this.cars = names.stream().map(Car::new).toList();
    }

    public void moveAllCars(final RandomNumber randomNumber) {
        for(Car car: cars) {
            final int condition = randomNumber.generate();
            car.move(condition);
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> determineWinner() {
        Car winnerCar = cars.stream()
                .max(Comparator.comparing(Car::getCount))
                .get();
        return cars.stream()
                .filter(car -> car.isSameCount(winnerCar))
                .toList();
    }
}
