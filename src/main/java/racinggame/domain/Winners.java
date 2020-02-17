package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    List<String> winners;

    public Winners(List<Car> winnerCars) {
        winners = new ArrayList<>();
        for (Car car : winnerCars) {
            winners.add(car.getName());
        }
    }

    public List<String> getNames() {
        return winners;
    }
}
