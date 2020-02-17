package model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private int maxPosition;
    private List<String> winners = new ArrayList<>();

    public int getMaxPosition(List<Car> cars) {
        calculateMaxPosition(cars);
        return maxPosition;
    }

    private void calculateMaxPosition(List<Car> cars) {
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.position.getPosition());
        }
    }

    public List<String> getWinners() {
        return this.winners;
    }

    public void setWinners(List<Car> cars) {
        cars.stream()
                .filter(x -> x.position.isMaxPosition(getMaxPosition(cars)))
                .forEach(x -> winners.add(x.getName()));
    }
}
