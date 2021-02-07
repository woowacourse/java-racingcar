package racingcar.controller;

import static racingcar.domain.game.Game.*;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.game.Game;
import racingcar.utils.RandomUtils;
import racingcar.view.GamePage;

public class GameController {

    public void startGame(Game game) {
        GamePage.printResultPage();
        while (game.notFinished()) {
            game.incrementCount();
            playSingleRound();
        }
        GamePage.printFinalResult(CarRepository.collectWinnerNames());
    }

    public void playSingleRound() {
        for (Car car : CarRepository.cars()) {
            car.tryToMoveForward(RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE));
        }
        GamePage.printSingleRoundResult();
    }
}
