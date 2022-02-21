package carracinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public static final int FIRST_CAR_INDEX = 0;

    public List<Car> findWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(FIRST_CAR_INDEX));
        for (int i = FIRST_CAR_INDEX + 1; i < cars.size(); i++) {
            winners = updateWinner(cars.get(i), winners);
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