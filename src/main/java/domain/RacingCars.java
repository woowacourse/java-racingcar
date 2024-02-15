package domain;

import static domain.ExceptionMessages.DUPLICATE_CAR_NAME_EXCEPTION;
import static domain.ExceptionMessages.TRY_COUNT_NUMBER_FORMAT_EXCEPTION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        Set<Car> distinctCars = new HashSet<>(racingCars);
        if (racingCars.size() != distinctCars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_EXCEPTION.getMessage());
        }
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

    private static void validateCounts(String counts) {
        try {
            Integer.parseInt(counts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_FORMAT_EXCEPTION.getMessage());
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
        return car.getCarName()
                + " : "
                + distance.repeat(car.getDistance());
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
