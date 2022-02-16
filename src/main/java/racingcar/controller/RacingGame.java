package racingcar.controller;

import racingcar.models.Car;
import racingcar.models.Cars;
import racingcar.views.Input;
import racingcar.views.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Input input;
    private final Output output;
    private Cars cars;
    private int repeats;

    public RacingGame(final Input input, final Output output) {
        this.input = input;
        this.output = output;
        repeats = 0;
    }

    public void startGame() {
        inputValidData();
        startRacing();
    }

    private void inputValidData() {
        createCar();
        repeats = input.inputRepeats();
    }

    private void createCar() {
        final List<String> carNames = input.inputValidNames();
        final List<Car> carInput = new ArrayList<>();
        carNames.forEach((carName) -> carInput.add(new Car(carName)));
        cars = new Cars(carInput);
    }

    private void startRacing() {
        output.printResultMessage();
        while (repeats-- > 0) {
            cars.startOneTurn();
            output.printTurnResult(cars.turnResult());
        }
        output.printWinners(cars.findWinner());
    }
}
