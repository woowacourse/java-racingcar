package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Round;
import racingcar.view.OutputView;

public class GameController {

    private final InputController inputController;
    private final OutputView outputView;

    public GameController(final InputController inputController,
                          final OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {
        final Cars cars = getCars();
        final Round round = getRound();

        play(round, cars);

        outputView.printCarsPosition(cars.getCars());

        final List<String> winnersName = findWinnersName(cars);
        outputView.printWinners(winnersName);
    }

    private Cars getCars() {
        return inputController.getCars();
    }

    private Round getRound() {
        return inputController.getRound();
    }

    private void play(final Round round, final Cars cars) {
        final RandomNumberGenerator generator = new RandomNumberGenerator();

        while (round.isContinue()) {
            cars.go(generator);
            round.progress();

            outputView.printCarsPosition(cars.getCars());
        }
    }

    private List<String> findWinnersName(final Cars cars) {
        return cars.findWinners()
                .stream()
                .map(Car::getName)
                .toList();
    }
}
