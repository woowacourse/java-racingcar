package domain;

import domain.car.Car;

import java.util.List;

public class Winners {
    private final List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners from(RandomMovingCars randomMovingCars) {
        return new Winners(findWinners(randomMovingCars).stream()
                .map(RandomMovingCar::getName)
                .toList());
    }

    private static List<RandomMovingCar> findWinners(RandomMovingCars randomMovingCars) {
        int maxPosition = getMaxPosition(randomMovingCars);
        return randomMovingCars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

    }

    private static int getMaxPosition(RandomMovingCars randomMovingCars) {
        return randomMovingCars.getCars().stream()
                .mapToInt(RandomMovingCar::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinners() {
        return winners;
    }
}
