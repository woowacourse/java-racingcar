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
            playSingleRound();
        }
        GamePage.printFinalResult(game.winners());
    }

    public void playSingleRound() {
        for (Car car : CarRepository.cars()) {
            car.tryToMoveForward(Game.generateRandomInteger());
        }
        GamePage.printSingleRoundResult();
    }
}
