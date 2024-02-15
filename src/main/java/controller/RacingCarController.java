package controller;

import model.Cars;
import model.Round;
import view.InputView;
import java.io.IOException;
import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private Cars cars;
    private Round round;

    public RacingCarController() {
        this.inputView = new InputView();
    }

    public void run() throws IOException {
        readCarNames();
        readRound();
    }

    private void readCarNames() throws IOException {
        List<String> names = inputView.readCarNames();
        cars = Cars.from(names);
    }

    private void readRound() throws IOException {
        round = Round.from(inputView.readRound());
    }
}