package domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        Cars result = new Cars();
        result.addCars(carNames);
        return result;
    }

    private void addCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }

    public List<String> getWinners() {
        final int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(c -> c.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .max(Car::compareTo)
            .orElseThrow()
            .getPosition();
    }
}
