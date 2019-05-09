package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public void race() {
        for (Car car : carList) {
            car.move();
        }
    }

    public RaceStatusDto getRaceStatus() {
        return new RaceStatusDto(carList);
    }

    public List<String> getWinners() {
        Collections.sort(carList);
        Car winnerCar = carList.get(0);
        List<String> winnerNames = new ArrayList<>();
        for (Car car : carList) {
            if (!car.isMaxDistance(winnerCar))
                break;
            winnerNames.add(car.getName());
        }

        return winnerNames;
    }
}
