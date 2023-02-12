package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carInformation;
    private final List<String> winner = new ArrayList<>();

    public Cars(List<Car> carInformation) {
        this.carInformation = carInformation;
    }

    public void addCarInformation(Car car) {
        this.carInformation.add(car);
    }

    public List<Car> getCarInformation() {
        return this.carInformation;
    }

    public int findMaxDistance() {
        int maxDistance = -1;
        for (Car car : this.carInformation) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    public List<String> findWinner(int maxDistance) {
        for (Car car : this.carInformation) {
            compareDistance(car, maxDistance);
        }
        return winner;
    }

    private void compareDistance(Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            winner.add(car.getName());
        }
    }
}
