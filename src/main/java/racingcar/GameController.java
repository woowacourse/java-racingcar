package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.domain.Winners;
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

    private List<Car> initCars() {
        String input = inputView.inputCarName();
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void runGame() {
        while (gameTime.isNotZero()) {
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
        Winners winners = new Winners(cars.calculateWinners());
        cars.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        outputView.printWinners(winners.toString());
    }
}
