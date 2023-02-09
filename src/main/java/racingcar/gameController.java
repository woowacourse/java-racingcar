package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private RacingGame racingGame;


    public gameController() {
        List<Car> cars = initCars();
        int gameTime = inputView.inputGameTime();
        racingGame = new RacingGame(gameTime, cars);
    }

    private List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        String input = inputView.inputCarName();
        String[] split = input.split(",");
        Arrays.stream(split).forEach(carName -> cars.add(new Car(carName.trim())));
        return cars;
    }

    public void runSingleRound() {
        racingGame.moveCars();
        racingGame.getCars().forEach(car -> outputView.printPosition(car.getName(), car.getPosition()));
    }
}
