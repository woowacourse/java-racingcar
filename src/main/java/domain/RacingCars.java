package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void startRound() {
        racingCars.forEach(RacingCars::moveCar);
    }

    public static void moveCar(Car car) {
        if (Racing.isMoveForward()) {
            car.moveForward();
        }
    }

    public String getRoundResult() {
        return racingCars.stream()
                .map(RacingCars::generateResult)
                .collect(Collectors.joining("\n"));
    }

    private static String generateResult(Car car) {
        String distance = "-";
        return car.getCarName() + " : " + distance.repeat(car.getDistance());
    }

    public String getWinners() {
        return racingCars.stream()
                .filter(car -> car.getDistance() == getMaxDistance())
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
    }
}
