package racing.util;

import racing.domain.Cars;

public class Finder {
    public static int findMaxStep(Cars cars) {
        return cars.compareStep();
    }

}
