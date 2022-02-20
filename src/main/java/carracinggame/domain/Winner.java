package carracinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private int maxPosition = Integer.MIN_VALUE;

    public List<Car> findWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(0));
        for (Car car : cars) {
            winners = updateWinner(car, winners);
        }
        return winners;
    }

    private List<Car> updateWinner(Car car, List<Car> winners) {
        if (car.isWinner(winners.get(0))) {
            winners.clear();
            winners.add(car);
            return winners;
        }
        if (car.isCoWinner(winners.get(0))) {
            winners.add(car);
        }
        return winners;
    }
}
