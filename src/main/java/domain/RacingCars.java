package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public String startRounds(String counts) {
        validateCounts(counts);
        int roundCounts = Integer.parseInt(counts);
        StringBuilder roundResult = new StringBuilder();
        for (int i = 0; i < roundCounts; i++) {
            racingCars.forEach(RacingCars::moveCar);
            roundResult.append(getRoundResult());
            roundResult.append("\n\n");
        }
        return roundResult.toString();
    }

    private static void validateCounts(String name) {
        try {
            Integer.parseInt(name);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void moveCar(Car car) {
        if (Racing.isMoveForward()) {
            car.moveForward();
        }
    }

    private String getRoundResult() {
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
