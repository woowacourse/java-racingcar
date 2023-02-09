package car.controller;

import java.util.ArrayList;
import java.util.List;

import car.domain.Car;
import car.domain.Game;
import car.domain.RandomMoveChance;
import car.view.InputView;
import car.view.OutputView;

public class GameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final Game game;
    private final int trialCount;

    public GameController() {
        List<String> carNames = List.of(inputView.inputCarNames());
        game = new Game(makeCarsWith(carNames), new RandomMoveChance());
        trialCount = inputView.inputTrialCount();
    }

    public void play() {
        outputView.noticeResult();
        playMultipleTimes();
    }

    public void showResult() {
        showCars(game.getCars());
        outputView.printWinners(game.findWinners());
    }

    private void playMultipleTimes() {
        for (int i = 0; i < trialCount; i++) {
            game.playOnce();
            showCars(game.getCars());
        }
    }

    private void showCars(List<Car> cars) {
        for (Car car : cars) {
            outputView.printCar(car);
        }
        outputView.changeLine();
    }

    private List<Car> makeCarsWith(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
