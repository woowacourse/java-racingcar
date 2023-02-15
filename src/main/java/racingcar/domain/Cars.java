package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.IntGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new LinkedList<>();
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public Cars(List<String> carNames, IntGenerator intGenerator) {
        this.cars = new LinkedList<>();
        carNames.forEach(carName -> cars.add(new Car(carName, intGenerator)));
    }

    public Cars(List<Car> cars, boolean isTest) {
        this.cars = cars;
    }

    public void requestMoveEachCar() {
        cars.forEach(Car::tryMove);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        int winnerCount = getWinnerCount();
        return cars.stream()
                .filter(car -> car.getMovedCount() == winnerCount)
                .collect(Collectors.toList());
    }

    private int getWinnerCount() {
        return cars.stream()
                .mapToInt(Car::getMovedCount)
                .max()
                .orElseThrow();
    }

    public boolean isEmpty() {
        return this.cars.isEmpty();
    }

}
