package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<String> winners = new ArrayList<>();

    public List<String> determineWinnerNames(Cars cars) {
        List<Car> winningCars = cars.determineWinners();
        for (Car winner : winningCars) {
            winners.add(winner.getName());
        }
        return winners;
    }
}
