package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerNames {
    private List<String> names;

    private WinnerNames(List<String> names) {
        this.names = names;
    }

    public static WinnerNames of(ParticipatedCars participatedCars) {
        List<String> names = getWinnerNamesFromCars(participatedCars.getCars());
        return new WinnerNames(names);
    }

    private static List<String> getWinnerNamesFromCars(List<Car> cars) {
        int fastestPosition = findFastestPosition(cars);
        return cars.stream()
                .filter(car -> car.isSamePositionWith(fastestPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int findFastestPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinnerNames() {
        return Collections.unmodifiableList(names);
    }
}
