package racing.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxDistance = getMaxDistance();
        for (Car car : cars) {
            determineWinner(winners, car, maxDistance);
        }
        return winners;
    }

    private int getMaxDistance() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    private void determineWinner(List<String> winners, Car car, int maxDistance) {
        if (car.matchPosition(maxDistance)) {
            winners.add(car.getName());
        }
    }
}
