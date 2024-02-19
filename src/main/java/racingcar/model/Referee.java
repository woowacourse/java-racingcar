package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<String> winners = new ArrayList<>();

    public int determineFarthestDistance(Cars cars) {
        return cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> determineWinnerNames(Cars cars) {
        int finalMaxPosition = determineFarthestDistance(cars);
        List<Car> winningCars = cars.determineWinners(finalMaxPosition);
        for (Car winner : winningCars) {
            winners.add(winner.getName());
        }
        return winners;
    }
}
