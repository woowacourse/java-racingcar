package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.game.Game;
import racingcar.utils.RandomUtils;
import racingcar.view.GamePage;

import java.util.List;

public class GameController {

    private static final int ZERO_FUEL = 0;
    private static final int FULL_FUEL = 9;

    public void startGame(Game game) {
        GamePage.printGamePage();
        playGame(game);
        endGame();
    }

    public void playGame(Game game) {
        while (game.notFinished()) {
            game.incrementCount();
            playSingleRound();
        }
    }

    public void playSingleRound() {
        CarRepository.cars().forEach(car -> car.tryToMoveForward(fillFuel()));
        GamePage.printSingleRoundResult(CarRepository.cars());
    }

    public int fillFuel() {
        return RandomUtils.nextInt(ZERO_FUEL, FULL_FUEL);
    }

    public int getMaxPosition() {
        return CarRepository.cars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public void endGame() {
        List<Car> winners = CarRepository.selectWinners(getMaxPosition());
        GamePage.printFinalResult(winners);
    }
}
