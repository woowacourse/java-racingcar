package domain;

import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
        return new Winners(getWinners(cars));
    }

    private static List<Car> getWinners(Cars cars) {
        return cars.getMaxDistanceCars();
    }

    public List<Car> getWinners() {
        return winners;
    }
}
