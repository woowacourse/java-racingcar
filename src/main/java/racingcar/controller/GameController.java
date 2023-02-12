package racingcar.controller;

import racingcar.domain.carfactory.CarFactory;
import racingcar.domain.racingcars.RacingCars;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.gameresult.GameResult;
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
        RacingGame racingGame = playRace();
        printResult(racingCars, racingGame);
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

    private RacingGame playRace() {
        while (true) {
            try {
                return new RacingGame(inputView.readGameRound(), new NumberGenerator());
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    private void printResult(RacingCars racingCars, RacingGame racingGame) {

        outputView.printResultGuide();

        GameResult gameResult = racingGame.startRace(racingCars);
        outputView.printResult(gameResult);
        outputView.printWinners(gameResult);
    }
}
