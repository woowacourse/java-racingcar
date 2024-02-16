package domain;

import domain.Car;
import domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    public List<String> findWinners(Cars cars) {
        List<Car> winners = cars.getCars().stream()
                .sorted(Car::compareTo)
                .takeWhile(car -> car.getForward() == cars.getMaxForward())
                .toList();

        return getWinnerNames(winners);
    }

    private List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        winners.forEach(winner -> winnerNames.add(winner.getName()));

        return winnerNames;
    }
}
