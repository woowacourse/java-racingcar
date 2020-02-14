package model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static int maxPosition = 0;
    private List<String> winners = new ArrayList<>();

    int getMaxPosition(List<Car> cars) {
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public void setWinner(List<Car> cars) {
        cars.stream()
                .filter(x -> x.isMaxPosition(getMaxPosition(cars)))
                .forEach(x -> winners.add(x.getName()));
    }

    public List<String> getWinners() {
        return this.winners;
    }
}
