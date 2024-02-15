package domain;

import java.util.List;

public class Winners {
    private final List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners from(Cars cars) {
        return new Winners(getWinners(cars).stream()
                .map(Car::getName)
                .toList());
    }

    public static List<Car> getWinners(Cars cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

    }

    private static int getMaxPosition(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinners() {
        return winners;
    }
}
