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

    private static final int ZERO_VALUE = 0;

    public RacingCarController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void generateCars() {
        RacingCarView.carListInput();
        String carsInput = scanner.nextLine();
        this.cars = CarsSetGenerator.generateSet(carsInput);
    }

    public void receiveTurns() {
        RacingCarView.turnNumberInput();
        String candidateTurn = scanner.nextLine();
        this.turns = TurnsGenerator.generateTurn(candidateTurn);
    }

    public void playGame() {
        RacingCarView.showResultMessage();
        for (int i = ZERO_VALUE; i < this.turns; i++) {
            cars.processOneTurn();
            List<Car> carList = cars.getList();
            carList.forEach(RacingCarView::displayPosition);
            RacingCarView.displayTurnInterval();
        }
    }

    public void endGame() {
        RacingCarView.showWinner(cars.findWinners());
    }
}
