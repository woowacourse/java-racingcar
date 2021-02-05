package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.RacingCarError;
import racingcar.view.RacingCarView;

import java.util.*;

public class RacingCarController {
    private Scanner scanner;
    private Cars cars;
    private int turns;

    private static final String DELIMITER = ",";
    private static final int ZERO_VALUE = 0;
    private static final int UPPER_LIMIT = 5;
    private static final long LONG_ZERO_VALUE = 0L;

    public RacingCarController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void generateCars() {
        RacingCarView.carListInput();
        String carsInput = scanner.nextLine();
        String[] parsedCarsInput = carsInput.split(DELIMITER);
        List<String> carNameCandidates = Arrays.asList(parsedCarsInput);
        checkNames(carNameCandidates);
        this.cars = new Cars(carNameCandidates);
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
                .filter(carNameLength -> carNameLength <= ZERO_VALUE)
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
        RacingCarView.turnNumberInput();
        String turnsInput = scanner.nextLine();
        int intTurns = Integer.parseInt(turnsInput);
        this.turns = intTurns;
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

    public void playGame() {
        RacingCarView.showResultMessage();
        for (int i = ZERO_VALUE; i < this.turns; i++) {
            cars.processOneTurn();
            List<Car> carList = cars.getList();
            carList.stream()
                .forEach(RacingCarView::displayPosition);
            RacingCarView.displayTurnInterval();
        }
    }

    public void endGame() {
        RacingCarView.showWinner(cars.findWinners());
    }
}
