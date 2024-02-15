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
    private Cars cars;
    private Round round;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() throws IOException {
        readCarNames();
        readRound();
        playRacing();
        findWinners();
    }

    private void readCarNames() throws IOException {
        List<String> names = inputView.readCarNames();
        cars = Cars.from(names);
    }

    private void readRound() throws IOException {
        round = Round.from(inputView.readRound());
    }

    private void playRacing() {
        outputView.writeResultMessage();
        for (int i=0; i<round.getRound(); i++) {
            cars.moveCars();
            outputView.writeRoundResult(cars);
        }
    }

    private void findWinners() {
        outputView.writeWinners(cars.findWinnerNames());
    }
}