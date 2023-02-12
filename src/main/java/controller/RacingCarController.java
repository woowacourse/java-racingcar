package controller;

import domain.Names;
import domain.RacingGame;
import domain.RepeatCount;
import domain.Winners;
import output.Outputs;
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

        Winners winners = racingGame.getWinner();
        OutputView.printWinners(winners);
    }
}
