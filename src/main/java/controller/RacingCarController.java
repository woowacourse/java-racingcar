package controller;

import domain.Cars;
import domain.RacingGame;
import output.Outputs;
import utils.Names;
import utils.RepeatCount;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public void run() {
        Names names = InputView.readNames();
        RepeatCount repeatCount = InputView.readRepeatCount();
        OutputView.printTitle();

        RacingGame racingGame = new RacingGame(names, repeatCount);
        while (racingGame.canRace()) {
            Outputs outputs = racingGame.race();
            OutputView.printOutputs(outputs);
        }

        Cars winners = racingGame.getWinner();
        OutputView.printWinners(winners);
    }
}
