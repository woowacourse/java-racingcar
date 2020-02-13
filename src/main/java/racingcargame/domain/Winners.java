package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners = new ArrayList<>();

    public Winners(List<Car> winnerCars) {
        winners.addAll(winnerCars);
    }

    public boolean contain(String name) {
        return winners.stream()
                .anyMatch(car -> car.isSame(name));
    }
}
