package domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import genertor.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.getNum());
        }
    }

    public List<Car> findWinners() {
        int winnerValue = cars.stream().max(Comparator.comparingInt(Car::getPosition)).get().getPosition();
        return cars.stream().filter(
                car -> car.getPosition() == winnerValue)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

}
