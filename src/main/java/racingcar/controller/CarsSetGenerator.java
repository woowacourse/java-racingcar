package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Cars;
import racingcar.view.RacingCarError;

public class CarsSetGenerator {

    private static final String DELIMITER = ",";
    private static final int ZERO_VALUE = 0;
    private static final int UPPER_LIMIT = 5;
    private static final long LONG_ZERO_VALUE = 0L;

    public static Cars generateSet(String carsInput) {
        List<String> carNameCandidates = carsNameStringToList(carsInput);
        checkNames(carNameCandidates);
        return new Cars(carNameCandidates);
    }

    public static List<String> carsNameStringToList(String carsInput) {
        String[] parsedCarsInput = carsInput.split(DELIMITER);
        return Arrays.asList(parsedCarsInput);
    }

    public static void checkNames(List<String> nameCandidates) {
        checkOverlappedNames(nameCandidates);
        checkNameLength(nameCandidates);
        checkNull(nameCandidates);
    }

    private static void checkOverlappedNames(List<String> nameCandidates) {
        Set<String> targetSet = new HashSet<>(nameCandidates);
        if (nameCandidates.size() != targetSet.size()) {
            RacingCarError.overlapped();
        }
    }

    private static void checkNameLength(List<String> nameCandidates) {
        checkUpperLimit(nameCandidates);
        checkLowerLimit(nameCandidates);
    }

    private static void checkUpperLimit(List<String> nameCandidates) {
        long nameFilters = nameCandidates.stream()
            .mapToInt(String::length)
            .filter(carNameLength -> carNameLength > UPPER_LIMIT)
            .count();
        if (nameFilters != LONG_ZERO_VALUE) {
            RacingCarError.upperLength();
        }
    }

    private static void checkLowerLimit(List<String> nameCandidates) {
        long nameFilters = nameCandidates.stream()
            .mapToInt(String::length)
            .filter(carNameLength -> carNameLength <= ZERO_VALUE)
            .count();
        if (nameFilters != LONG_ZERO_VALUE) {
            RacingCarError.lowerLength();
        }
    }

    private static void checkNull(List<String> nameCandidates) {
        if (nameCandidates.size() == ZERO_VALUE) {
            RacingCarError.nullCar();
        }
    }
}
