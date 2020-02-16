package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    List<Car> winners;

    public Winners(List<Car> winnerCars) {
        winners = new ArrayList<>();
        for (Car car : winnerCars) {
            winners.add(car);
        }
    }

    public List<String> makeWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for(Car car: winners){
            winnerNames.add(car.makeWinnerLog());
        }
        return winnerNames;
    }
}
