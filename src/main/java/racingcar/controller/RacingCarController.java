package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.RacingCarError;
import racingcar.view.RacingCarView;

import java.util.*;

public class RacingCarController {
    private static final String DELIMITER = ",";
    private static Scanner scanner;
    private static Cars cars;
    private int turns;

    public RacingCarController(Scanner scanner) {
        this.scanner = scanner;
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
