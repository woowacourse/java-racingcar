package controller;

import domain.Cars;
import domain.Count;
import domain.RacingGame;
import view.InputView;
import view.ResultView;

public class CarRaceStarter {

    public void start() {
        Cars cars = InputView.getCarNames();
        Count count = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(cars, count);
        racingGame.race();

        ResultView.PrintWinners(racingGame.getWinners());
    }
}
