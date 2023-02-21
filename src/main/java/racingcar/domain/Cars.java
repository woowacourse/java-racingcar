package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final List<String> winner = new ArrayList<>();

    public Cars(List<String> carNames) {
        this.cars = convertToCar(carNames);
    }

    private List<Car> convertToCar(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCarInformation() {
        return this.cars;
    }

    public int findMaxDistance() {
        int maxDistance = -1;
        for (Car car : this.cars) {
            maxDistance = Math.max(car.getDistance().getDistance(), maxDistance);
        }
        return maxDistance;
    }

    public List<String> findWinner(int maxDistance) {
        for (Car car : this.cars) {
            compareDistance(car, maxDistance);
        }
        return winner;
    }

    private void compareDistance(Car car, int maxDistance) {
        if (car.getDistance().getDistance() == maxDistance) {
            winner.add(car.getName().getName());
        }
    }
}
