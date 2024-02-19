package controller;

import model.Car;
import model.Game;
import model.TrialCount;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() throws IOException {
        Game game = new Game(inputView.inputCarsName());
        TrialCount trialCount = new TrialCount(inputView.inputTrialCount());
        outputView.printResultComment();
        while (trialCount.isRest()) {
            outputView.printResult(game.proceed());
            trialCount.reduce();
        }
        outputView.printWinner(game.findWinners());
    }
}
