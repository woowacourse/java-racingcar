package domain;

import java.util.Collections;
import java.util.List;

public class Judge {

    public List<Car> getWinners(List<Car> cars) {
        cars.sort(Collections.reverseOrder());
        int furthestLocation = cars.get(0).getLocation();
        return cars.stream()
                .filter(car -> car.getLocation() == furthestLocation)
                .toList();
    }
}
