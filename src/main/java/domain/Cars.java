package domain;

import dto.Winners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        validateUniqueName(carNames);
        List<Car> cars = convertToCarList(carNames);
        this.cars = cars;
    }

    private List<Car> convertToCarList(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(new CarName(name)))
                .toList();
    }

    private void validateUniqueName(List<String> names) {
        if(isDuplicatedName(names)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicatedName(List<String> names) {
        return getDistinctCount(names) != names.size();
    }

    private int getDistinctCount(List<String> names) {
        return (int) names.stream()
                .distinct()
                .count();
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Winners judge() {
        List<String> winners = new ArrayList<>();
        int max = findMaxPosition();
        for(Car car : cars)  {
            Optional<String> maxCarName =  car.getNameIfMax(max);
            if(maxCarName.isPresent()) {
                winners.add(maxCarName.get());
            }
        }
        return new Winners(winners);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElseThrow(() -> new IllegalStateException());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
