package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.RacingCarError;
import racingcar.view.RacingCarView;

import java.util.*;

public class RacingCarController {
    private static final String DELIMITER = ",";
    private static final int UPPER_LIMIT = 5;
    private Scanner scanner;
    private Cars cars;
    private int turns;

    public RacingCarController(Scanner scanner) {
        this.scanner = scanner;
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
        if (nameFilters != 0) {
            RacingCarError.upperLength();
        }
    }

    private static void checkLowerLimit(List<String> nameCandidates) {
        long nameFilters = nameCandidates.stream()
                .mapToInt(carName -> carName.length())
                .filter(carNameLength -> carNameLength <= 0)
                .count();
        if (nameFilters != 0) {
            RacingCarError.lowerLength();
        }
    }

    private static void checkNull(List<String> nameCandidates) {
        if (nameCandidates.size() == 0) {
            RacingCarError.nullCar();
        }
    }

    public static void checkTurns(String turnCandidate) {
        int integerCandidate = checkInteger(turnCandidate);
        checkNegative(integerCandidate);
    }

    private static int checkInteger(String turnCandidate) {
        try {
            return Integer.parseInt(turnCandidate);
        } catch (Exception e) {
            RacingCarError.notInteger();
            return 0;
        }
    }

    private static void checkNegative(int integerCandidate) {
        if (integerCandidate < 0) {
            RacingCarError.negativeInteger();
        }
    }

    public void generateCars() {
        RacingCarView.carListInput();
        String carsInput = scanner.nextLine();
        String[] parsedCarsInput = carsInput.split(DELIMITER);
        List<String> carNameCandidates = Arrays.asList(parsedCarsInput);
        checkNames(carNameCandidates);
        this.cars = new Cars(carNameCandidates);
    }

    public void receiveTurns() {
        RacingCarView.turnNumberInput();
        String turnsInput = scanner.nextLine();
        int intTurns = Integer.parseInt(turnsInput);
        this.turns = intTurns;
    }

    public void playGame() {
        RacingCarView.showResultMessage();
        for (int i = 0; i < this.turns; i++) {
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
