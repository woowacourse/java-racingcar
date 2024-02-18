package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<String> names;

    private Winner(final List<String> names) {
        this.names = names;
    }

    public static Winner from(final Cars cars) {
        int carCount = cars.getSize();

        int headPosition = 0;
        for (int i = 0; i < carCount; i++) {
            headPosition = Math.max(headPosition, cars.getCarPositionOf(i));
        }

        List<String> carNames = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            if (cars.getCarPositionOf(i) == headPosition) {
                carNames.add(cars.getCarNameOf(i));
            }
        }
        return new Winner(carNames);
    }

    public List<String> getNames() {
        return names;
    }
}
