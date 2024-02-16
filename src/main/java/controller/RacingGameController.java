package controller;

import domain.Car;
import domain.Cars;
import domain.MoveCount;
import java.util.List;
import util.StringParser;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        Cars cars = prepareCars();
        MoveCount moveCount = prepareMoveCount();

        outputView.printResultPrefix();

        executeRace(cars, moveCount);

        findWinners(cars);
    }

    private void findWinners(Cars cars) {
        List<Car> winners = cars.chooseWinners();
        outputView.printWinner(winners);
    }

    private void executeRace(Cars cars, MoveCount moveCount) {
        while (!moveCount.isCountZero()) {
            cars.tryMoveAll();
            moveCount.consume();
            outputView.printRaceResult(cars.getCars());
        }
    }

    private Cars prepareCars() {
        try {
            String name = inputView.requestCarName();
            List<String> carNames = StringParser.split(name, ",");
            return Cars.from(carNames.stream()
                    .map(carName -> Car.of(carName, 0))
                    .toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return prepareCars();
        }
    }

    private MoveCount prepareMoveCount() {
        try {
            Integer count = StringParser.parseToInt(inputView.requestMoveCount());
            return MoveCount.from(count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return prepareMoveCount();
        }
    }
}