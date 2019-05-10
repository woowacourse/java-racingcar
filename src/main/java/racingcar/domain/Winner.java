package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winner {
    private List<Car> cars;
    private int maxDistance = 0;

    public Winner(List<Car> carList) {
        this.cars = carList;
    }

    public String getWinner() {
        List<String> winners = new ArrayList<>();

        getMaxDistance();
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winners.add(car.getName());
            }
        }

        return String.join(",", winners);
    }

    private void getMaxDistance() {
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
    }

    protected int getMaxDistance2() {
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
        return maxDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winner winner = (Winner) o;
        return maxDistance == winner.maxDistance &&
                Objects.equals(cars, winner.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, maxDistance);
    }
}
