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

    public void play() {
        List<String> carNames = List.of(inputView.inputCarNames());
        List<Car> cars = makeCars(carNames);
        Game game = new Game(cars, new RandomMoveChance());
        outputView.noticeResult();
        playMultiple(game);
        printCars(game.getCars());
        outputView.printWinners(game.findWinners());
    }

    private void playMultiple(Game game) {
        int trialCount = inputView.inputTrialCount();
        for (int i = 0; i < trialCount; i++) {
            game.playOnce();
            printCars(game.getCars());
        }
    }

    private void printCars(List<Car> cars) {
        for (Car car : cars) {
            outputView.printCar(car);
        }
        outputView.changeLine();
    }

    private List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
