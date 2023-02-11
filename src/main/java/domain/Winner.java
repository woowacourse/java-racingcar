package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<String> winners;

    public Winner(Cars cars) {
        this.winners = new ArrayList<>();
        int maxDistance = findMaxDistanceCar(cars);
        findWinner(cars, maxDistance);
    }

    private int findMaxDistanceCar(Cars cars) {
        int maxDistance = 0;
        for (int i = 0; i < cars.getCarsSize(); i++) {
            maxDistance = Math.max(maxDistance, cars.getCar(i).getDistance());
        }
        return maxDistance;
    }

    private void findWinner(Cars cars, int maxDistance) {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            addWinner(cars, maxDistance, i);
        }
    }

    private void addWinner(Cars cars, int maxDistance, int i) {
        if (cars.getCar(i).getDistance() == maxDistance) {
            winners.add(cars.getCar(i).getName());
        }
    }

    public List<String> getWinners() {
        return winners;
    }
}
