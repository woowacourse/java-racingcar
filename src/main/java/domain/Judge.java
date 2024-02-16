package domain;

import java.util.Collections;
import java.util.List;

public class Judge {

    public List<Car> getWinners(Cars cars) {
        cars.getCars().sort(Collections.reverseOrder());
        int furthestLocation = cars.getWinnerLocation();
        return cars.getWinners(furthestLocation);
    }
}
