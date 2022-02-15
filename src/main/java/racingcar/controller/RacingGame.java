package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.models.Car;
import racingcar.utils.RandomNumber;
import racingcar.views.Input;
import racingcar.views.Output;

public class RacingGame {

    private final Input input;
    private final Output output;
    private final List<Car> cars = new ArrayList<>();
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
        carNames.forEach((carName) -> cars.add(new Car(new RandomNumber(), carName)));
    }

    private void startRacing() {
        output.printResultMessage();
        while (repeats-- > 0) {
            cars.forEach(Car::goForward);
            output.printTurnResult(cars);
        }
        output.printWinners(findWinner());
    }

    private String findWinner() {
        final int farthestPosition = findFarthestPosition();
        return getWinners(farthestPosition);
    }

    private int findFarthestPosition() {
        List<Car> sortedCars = cars.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .collect(Collectors.toList());

        if (!sortedCars.isEmpty()) {
            return sortedCars.get(0).getPosition();
        }
        return 0;
    }

    private String getWinners(final int farthestPosition) {
        return cars.stream()
                .filter((car) -> farthestPosition == car.getPosition())
                .map(Car::toString)
                .collect(Collectors.joining(", "));
    }
}
