package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerCars {
    private List<Car> winnerCars;

    public void determineWinners(GameResult gameResult) {
        winnerCars = new ArrayList<>();
        List<Car> cars = gameResult.getCars();

        Collections.sort(cars);
        Car maxPositionCar = cars.get(0);

        for (Car car : cars) {
            if (!maxPositionCar.isEqualPosition(car)) {
                break;
            }

            winnerCars.add(car);
        }
    }

    public List<Car> getWinnerCars() {
        return Collections.unmodifiableList(winnerCars);
    }
}
