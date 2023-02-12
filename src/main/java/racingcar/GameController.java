package racingcar;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private static final String DELIMITER = ",";

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final Cars cars;
    private final GameTime gameTime;

    public GameController() {
        this.cars = new Cars(initCars());
        this.gameTime = initGameTime();
    }

    private static GameTime initGameTime() {
        String gameTime = inputView.inputGameTime();
        return new GameTime(gameTime);
    }

    private String initCars() {
        return inputView.inputCarName();
    }

    public void runGame() {
        while (gameTime.isInPlay()) {
            runSingleRound();
            gameTime.runOnce();
        }
    }

    private void runSingleRound() {
        cars.moveCarsRandomly();
        cars.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        System.out.println();
    }

    public void finishGame() {
        Winners winners = new Winners(cars);
        cars.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        outputView.printWinners(winners.toString());
    }
}
