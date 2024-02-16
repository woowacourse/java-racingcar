package domain;

import java.util.Collections;
import java.util.List;

public class Judge {

    public List<Car> getWinners(RaceCars raceCars) {
        List<Car> cars = raceCars.getCars();
        cars.sort(Collections.reverseOrder());
        int furthestLocation = cars.get(0).getLocation();
        return cars.stream()
                .filter(car -> car.getLocation() == furthestLocation)
                .toList();
    }
}
