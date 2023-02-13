package controller;

import java.util.List;
import service.CarFactory;
import service.RacingGame;
import strategy.MovingStrategy;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final InputView inputView;

    private final OutputView outputView;

    private final MovingStrategy movingStrategy;

    public RacingGameController(InputView inputView, OutputView outputView,
        MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
    }

    public void execute() {
        List<String> carNames = getCarNames();
        int tryTimes = getTryTimes();
        RacingGame racingGame = new RacingGame(CarFactory.buildCars(carNames), movingStrategy);
        race(racingGame, tryTimes);
        getWinners(racingGame);
    }

    private List<String> getCarNames() {
        outputView.printInputCarNamesNotice();
        return inputView.inputCarNames();
    }

    private int getTryTimes() {
        outputView.printInputTryTimesNotice();
        return inputView.inputTryTimes();
    }

    private void race(RacingGame racingGame, int tryTimes) {
        outputView.printResultNotice();

        for (int i = 0; i < tryTimes; i++) {
            outputView.printSingleRoundResult(racingGame.playSingleRound());
        }
    }

    private void getWinners(RacingGame racingGame) {
        outputView.printWinner(racingGame.getWinners());
    }
}
