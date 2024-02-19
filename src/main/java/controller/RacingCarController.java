package controller;

import model.Car;
import model.Cars;
import model.Round;
import view.InputView;
import view.OutputView;
import java.io.IOException;
import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() throws IOException {
        List<String> names = inputView.readCarNames();
        Cars cars = Cars.from(names);

        Round round = Round.from(inputView.readRound());

        outputView.printResultMessage();
        for (int i = 0; i < round.getRound(); i++) {
            cars.moveCars();
            printResult(cars);
        }

        outputView.printWinners(cars.findWinnerNames());
    }

    private void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            outputView.printRoundResult(car.getName(), car.getPosition());
        }
        System.out.println();
    }
}
