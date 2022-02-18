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
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private static int findFastestPosition(List<Car> cars) {
        int fastestPosition = 0;
        for (Car car : cars) {
            fastestPosition = Math.max(car.getPosition(), fastestPosition);
        }
        return fastestPosition;
    }

    public List<String> getWinnerNames() {
        return Collections.unmodifiableList(names);
    }
}
