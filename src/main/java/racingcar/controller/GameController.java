package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.game.Game;
import racingcar.view.GamePage;

public class GameController {

    public void startGame(Game game) {
        GamePage.printResultPage();
        while (game.notFinished()) {
            game.incrementCount();
            playSingleRound(game);
        }
        GamePage.printFinalResult(game.joinWinnerNames(CarRepository.collectWinners()));
    }

    public void playSingleRound(Game game) {
        for (Car car : CarRepository.cars()) {
            car.tryToMoveForward(game.generateRandomInteger());
        }
        GamePage.printSingleRoundResult(CarRepository.cars());
    }
}
