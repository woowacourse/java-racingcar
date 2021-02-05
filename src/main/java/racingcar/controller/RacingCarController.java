package racingcar.controller;

import racingcar.view.RacingCarError;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RacingCarController {
    private Scanner scanner;
    private static final String DELIMITER = ",";
    private static final int ZERO_VALUE = 0;
    private static final int UPPER_LIMIT = 5;
    private static final long LONG_ZERO_VALUE = 0L;

    public RacingCarController(Scanner scanner) {
        scanner = this.scanner;
    }

    public void receiveNames() {
        String carsInput = scanner.nextLine();
        String[] parsedCarsInput = carsInput.split(DELIMITER);
        List<String> carNameCandidates = Arrays.asList(parsedCarsInput);
        checkNames(carNameCandidates);
        Cars cars = new Cars(carNameCandidates);
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
            .mapToInt(carName -> carName.length())
            .filter(carNameLength -> carNameLength > UPPER_LIMIT)
            .count();

        if (nameFilters != LONG_ZERO_VALUE) {
            RacingCarError.upperLength();
        }
    }

    private static void checkLowerLimit(List<String> nameCandidates) {
        long nameFilters = nameCandidates.stream()
                .mapToInt(carName -> carName.length())
                .filter(carNameLength -> carNameLength > ZERO_VALUE)
                .count();

        if (nameFilters != LONG_ZERO_VALUE) {
            RacingCarError.lowerLength();
        }
    }

    private  static void checkNull(List<String> nameCandidates) {
        if (nameCandidates.size() == ZERO_VALUE) {
            RacingCarError.nullCar();
        }
    }

    public void receiveTurns() {
        String turnsInput = scanner.nextLine();
        int intTurns = Integer.parseInt(turnsInput);
    }

    public static void checkTurns(String turnCandidate) {
        int integerCandidate = checkInteger(turnCandidate);
        checkNegative(integerCandidate);
    }

    private static int checkInteger(String turnCandidate) {
        try {
            return Integer.parseInt(turnCandidate);
        } catch (Exception e){
            RacingCarError.notInteger();
            return ZERO_VALUE;
        }
    }

    private static void checkNegative(int integerCandidate) {
        if (integerCandidate < ZERO_VALUE) {
            RacingCarError.negativeInteger();
        }
    }
}
