package racingcar.controller;

import racingcar.domain.carfactory.CarFactory;
import racingcar.domain.gameresult.GameResult;
import racingcar.domain.racingcars.RacingCars;
import racingcar.domain.racinggame.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingCars racingCars = setCars();
        GameResult gameResult = playRace(racingCars);
        printResult(gameResult);
    }

    private RacingCars setCars() {
        CarFactory carFactory = new CarFactory();
        while (true) {
            try {
                return carFactory.setRacingCars(inputView.readCarNames());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private GameResult playRace(RacingCars racingCars) {
        while (true) {
            try {
                RacingGame racingGame = new RacingGame(inputView.readGameRound());
                return racingGame.startRace(racingCars);
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    private void printResult(GameResult gameResult) {
        outputView.printResultGuide();
        outputView.printResult(gameResult);
        outputView.printWinners(gameResult);
    }
}
