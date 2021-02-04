package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.car.Game;
import racingcar.view.GamePage;

public class GameController {

    private Game game;

    public void startGame(Game game) {
        this.game = game;
        GamePage.printResultPage();
        while (game.notFinished()) {
            game.incrementCount();
            playSingleRound();
        }
        GamePage.printFinalResult(game.collectWinners());
    }

    public void playSingleRound() {
        for (Car car : CarRepository.cars()) {
            car.tryToMoveForward(Game.generateRandomInteger());
        }
        GamePage.printSingleRoundResult();
    }
}
