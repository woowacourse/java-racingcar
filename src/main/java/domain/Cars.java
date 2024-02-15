package domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        validateUniqueName(carNames);
        List<Car> cars = carNames.stream()
                .map(name -> new Car(new CarName(name)))
                .toList();
        this.cars = cars;
    }

    private void validateUniqueName(List<String> names) {
        if(isDuplicatedName(names)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicatedName(List<String> names) {
        return names.stream()
                .distinct()
                .count() != names.size();
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }
}
