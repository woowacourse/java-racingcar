package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.game.Game;
import racingcar.utils.RandomUtils;
import racingcar.view.GamePage;

public class GameController {

    public void startGame(Game game) {
        GamePage.printResultPage();
        while (game.notFinished()) {
            game.play();
            playSingleRound();
        }
        GamePage.printFinalResult(CarRepository.cars());
    }

    public void playSingleRound() {
        for (Car car : CarRepository.cars()) {
            car.move(RandomUtils.nextInt(0, 9));
        }
        GamePage.printSingleRoundResult();
    }
}
