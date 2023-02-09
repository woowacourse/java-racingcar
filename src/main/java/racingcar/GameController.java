package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {

    private static final String DELIMITER = ",";


    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private final RacingGame racingGame;


    public GameController() {
        List<Car> cars = initCars();
        int gameTime = inputView.inputGameTime();
        racingGame = new RacingGame(gameTime, cars);
    }

    private List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        String input = inputView.inputCarName();
        String[] split = input.split(DELIMITER);
        Arrays.stream(split).forEach(carName -> cars.add(new Car(carName)));
        return cars;
    }

    public void runGame() {
        for (int i = 0; i < racingGame.getGameTime(); i++) {
            runSingleRound();
        }
    }

    private void runSingleRound() {
        racingGame.moveCars();
        racingGame.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        System.out.println();
    }

    public void finishGame() {
        racingGame.calculateWinners();
        racingGame.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
        outputView.printWinners(racingGame.getWinners());
    }
}
