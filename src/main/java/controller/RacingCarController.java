package controller;

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

        outputView.writeResultMessage();
        for (int i = 0; i < round.getRound(); i++) {
            cars.moveCars();
            outputView.writeRoundResult(cars);
        }

        outputView.writeWinners(cars.findWinnerNames());
    }
}
