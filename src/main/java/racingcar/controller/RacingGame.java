package racingcar.controller;

import racingcar.models.Car;
import racingcar.models.Cars;
import racingcar.views.Input;
import racingcar.views.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private int repeats;

    public RacingGame() {
        repeats = 0;
    }

    public void startGame() {
        inputValidData();
        startRacing();
    }

    private void inputValidData() {
        createCar();
        repeats = Input.inputRepeats();
    }

    private void createCar() {
        final List<String> carNames = Input.inputValidNames();
        final List<Car> carInput = new ArrayList<>();
        carNames.forEach((carName) -> carInput.add(new Car(carName)));
        cars = new Cars(carInput);
    }

    private void startRacing() {
        Output.printResultMessage();
        while (repeats-- > 0) {
            cars.startOneTurn();
            Output.printTurnResult(cars.turnInfo());
        }
        Output.printWinners(cars.findWinners());
    }
}
