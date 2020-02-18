package racingcargame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners = new ArrayList<>();

    public Winners(List<Car> winnerCars) {
        winners.addAll(winnerCars);
    }

    public List<String> getNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    List<Car> getValues() {
        return Collections.unmodifiableList(winners);
    }

    public static Winners extractWinners(List<Car> cars) {
        List<Car> racingCars = new ArrayList<>(cars);
        Collections.sort(racingCars);
        Car firstScoreCar = racingCars.get(racingCars.size() - 1);
        List<Car> winners = racingCars.stream()
                .filter(car -> car.isSameToPosition(firstScoreCar))
                .collect(Collectors.toList());
        return new Winners(winners);
    }
}
