package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerNames {
    private static final int SAME_POSITION = 0;

    private List<String> names;

    public static WinnerNames of(ParticipatedCars participatedCars, Car fastestCar) {
        WinnerNames winnerNames = new WinnerNames();
        winnerNames.names = new ArrayList<>();
        for (Car car : participatedCars.getCars()) {
            winnerNames.addWinnerByFastestCar(car, fastestCar);
        }
        return winnerNames;
    }

    private void addWinnerByFastestCar(Car car, Car fastest) {
        if (fastest.compareTo(car) == SAME_POSITION) {
            names.add(car.getCarName());
        }
    }

    public List<String> getWinnerNames() {
        return this.names;
    }
}
