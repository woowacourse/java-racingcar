package domain;

import dto.Winners;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Winners judge() {
        List<String> winners = new ArrayList<>();
        int max = cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElseThrow(() -> new IllegalStateException());
        for(Car car : cars)  {
            Optional<String> name =  car.getNameIfMax(max);
            if(name.isPresent()) {
                winners.add(name.get());
            }
        }
        return new Winners(winners);
    }
}
