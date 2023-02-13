package controller;

import domain.Names;
import domain.RacingGame;
import domain.RandomNumberGenerator;
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

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingGame racingGame = new RacingGame(names, repeatCount, randomNumberGenerator);
        while (racingGame.canRace()) {
            Outputs outputs = racingGame.race();
            OutputView.printOutputs(outputs);
        }

        Winners winners = racingGame.getWinner();
        OutputView.printWinners(winners);
    }
}
