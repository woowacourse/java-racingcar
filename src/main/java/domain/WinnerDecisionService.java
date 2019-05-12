package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerDecisionService {
    public static List<Car> decideWinners(GameResult gameResult) {
        List<Car> winnerCars = new ArrayList<>();
        List<Car> cars = gameResult.getCars();
        Car maxPositionCar = gameResult.decideMaxPositionCar();

        for (Car car : cars) {
            if (maxPositionCar.isEqualPosition(car)) {
                winnerCars.add(car);
            }
        }

        return Collections.unmodifiableList(winnerCars);
    }
}
