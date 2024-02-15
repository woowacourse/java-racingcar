package domain;

import java.util.List;

public record Winners(List<Car> winners) {

    public static Winners from(Cars cars) {
        return new Winners(getWinners(cars));
    }

    private static List<Car> getWinners(Cars cars) {
        return cars.getMaxDistanceCars();
    }
}
