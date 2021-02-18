package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.move.RandomStrategy;
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
        String carsInput = RacingCarView.carListInput(this.scanner);
        this.cars = CarsSetGenerator.generateSet(carsInput);
    }

    public void receiveTurns() {
        String candidateTurn = RacingCarView.turnNumberInput(this.scanner);
        this.turns = TurnsGenerator.generateTurn(candidateTurn);
    }

    public void playGame() {
        RacingCarView.showResultMessage();
        RandomStrategy randomMoveStartegy = new RandomStrategy();
        for (int i = ZERO_VALUE; i < this.turns; i++) {
            cars.processOneTurn(randomMoveStartegy);
            List<Car> carList = cars.getList();
            carList.forEach(RacingCarView::displayPosition);
            RacingCarView.displayTurnInterval();
        }
    }

    public void endGame() {
        RacingCarView.showWinner(cars.findWinners());
    }
}
