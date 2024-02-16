package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    public static final String DUPLICATE_CAR_NAME_EXCEPTION = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    public static final String TRY_COUNT_NUMBER_FORMAT_EXCEPTION = "[ERROR] 시도 횟수는 숫자여야 합니다.";

    private final List<Car> racingCars;

    public Cars(List<Car> racingCars) {
        Set<Car> distinctCars = new HashSet<>(racingCars);
        if (racingCars.size() != distinctCars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_EXCEPTION);
        }
        this.racingCars = racingCars;
    }

    private static void validateCounts(String counts) {
        try {
            Integer.parseInt(counts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static String generateResult(Car car) {
        String distance = "-";
        return car.getCarName()
                + " : "
                + distance.repeat(car.getDistance());
    }

    public String startRounds(String counts) {
        validateCounts(counts);
        int roundCounts = Integer.parseInt(counts);
        StringBuilder roundResult = new StringBuilder();
        for (int i = 0; i < roundCounts; i++) {
            racingCars.forEach(car -> car.moveForward(NumberGenerator.generateRandomNumber()));
            roundResult.append(getRoundResult());
            roundResult.append("\n\n");
        }
        return roundResult.toString();
    }

    private String getRoundResult() {
        return racingCars.stream()
                .map(Cars::generateResult)
                .collect(Collectors.joining("\n"));
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
