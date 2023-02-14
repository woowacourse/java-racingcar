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
        int winnerCount = 0;
        for (Car car : cars) {
            winnerCount = getMaxMovedCount(winnerCount, car.getMovedCount());
        }
        final int finalWinnerCount = winnerCount;
        return cars.stream()
                .filter(car -> car.getMovedCount() == finalWinnerCount)
                .collect(Collectors.toList());
    }
    
    private int getMaxMovedCount(int winnerCount, int movedCount) {
        return Math.max(winnerCount, movedCount);
    }

    public boolean isEmpty() {
        return this.cars.isEmpty();
    }

}
