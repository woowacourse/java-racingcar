package controller;

import model.Cars;
import model.RacingGame;
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
        final List<String> names = inputView.readCarNames();
        final Cars cars = Cars.from(names);

        final String round = inputView.readRound();
        final RacingGame racingGame = RacingGame.from(cars, round);

        racingGame.race();

        outputView.writeRacingResult(racingGame.getAllRacingRecord());
        outputView.writeWinners(racingGame.findWinnerNames());
    }
}
