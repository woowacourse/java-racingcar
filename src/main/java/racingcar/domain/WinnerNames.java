package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerNames {
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
        if (car.getPosition() == fastest.getPosition()) {
            names.add(car.getName());
        }
    }

    public List<String> getWinnerNames() {
        return this.names;
    }
}
